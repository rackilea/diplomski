import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

  public static final String ID = "wag.perspective";

  public void createInitialLayout(IPageLayout layout) {
    String editorArea = layout.getEditorArea();
    layout.setEditorAreaVisible(true);

    layout.addStandaloneView(AView.ID, false, IPageLayout.LEFT,
                             0.25f, editorArea);
    layout.addStandaloneView(BView.ID, false, IPageLayout.LEFT,
                             0.25f, editorArea);

    layout.getViewLayout(AView.ID).setCloseable(false);
    layout.getViewLayout(BView.ID).setCloseable(false);
  }
}