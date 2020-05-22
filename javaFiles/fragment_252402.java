import javax.swing.JComponent;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import sun.awt.AppContext;

public class DetectEdtViolationRepaintManager extends RepaintManager {

  private static final Logger LOGGER = Logger.getLogger(
    DetectEdtViolationRepaintManager.class);

  /**
   * Used to ensure we only print a stack trace once per abusing thread.  May
   * be null if the option is disabled.
   */
  private ThreadLocal alreadyWarnedLocal;

  /**
   * Installs a new instance of DetectEdtViolationRepaintManager which does not
   * warn repeatedly, as the current repaint manager.
   */
  public static void install() {
    install(false);
  }

  /**
   * Installs a new instance of DetectEdtViolationRepaintManager as the current
   * repaint manager.
   * @param warnRepeatedly whether multiple warnings should be logged for each
   *        violating thread
   */
  public static void install(boolean warnRepeatedly) {
    AppContext.getAppContext().put(RepaintManager.class, 
      new DetectEdtViolationRepaintManager(warnRepeatedly));
    LOGGER.info("Installed new DetectEdtViolationRepaintManager");
  }

  /**
   * Creates a new instance of DetectEdtViolationRepaintManager.
   * @param warnRepeatedly whether multiple warnings should be logged for each
   *        violating thread
   */
  private DetectEdtViolationRepaintManager(boolean warnRepeatedly) {
    if (!warnRepeatedly) {
      this.alreadyWarnedLocal = new ThreadLocal();
    }
  }

  /**
   * {@inheritDoc}
   */
  public synchronized void addInvalidComponent(JComponent component) {
    checkThreadViolations();
    super.addInvalidComponent(component);
  }

  /**
   * {@inheritDoc}
   */
  public synchronized void addDirtyRegion(JComponent component, int x, int y, 
    int w, int h) {
    checkThreadViolations();
    super.addDirtyRegion(component, x, y, w, h);
  }

  /**
   * Checks if the calling thread is called in the event dispatch thread.
   * If not an exception will be printed to the console.
   */
  private void checkThreadViolations() {
    if (alreadyWarnedLocal != null && Boolean.TRUE.equals(alreadyWarnedLocal.get())) {
      return;
    }
    if (!SwingUtilities.isEventDispatchThread()) {
      if (alreadyWarnedLocal != null) {
        alreadyWarnedLocal.set(Boolean.TRUE);
      }
      LOGGER.warn("painting on non-EDT thread", new Exception());
    }
  }
}