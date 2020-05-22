import java.io.PrintStream;
import java.util.Enumeration;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DebugLogging {

    private static final Logger log = Logger.getLogger("test");

    public static void main(String[] a) {
        log.log(Level.FINEST, "Finest");
        log.log(Level.FINER, "FINER");
        log.log(Level.FINE, "FINE");
        log.log(Level.CONFIG, "CONFIG");
        log.log(Level.INFO, "INFO");
        log.log(Level.WARNING, "WARNING");
        log.log(Level.SEVERE, "SEVERE");
        log.finest("Finest Log");
        log.finer("Finer Log");
        log.fine("Fine Log");
        log.config("Config Log");
        log.info("Info Log");
        log.warning("Warning Log");
        log.severe("Severe Log");
        printConfig(System.err);
    }

    private static void printConfig(PrintStream ps) {
        LogManager lm = LogManager.getLogManager();
        ps.append("LogManager=").println(lm.getClass().getName());
        synchronized (lm) {
            Enumeration<String> e = lm.getLoggerNames();
            while (e.hasMoreElements()) {
                Logger l = lm.getLogger(e.nextElement());
                if (l != null) {
                    print(l, ps);
                }
            }
        }
    }

    private static void print(Logger l, PrintStream ps) {
        String scn = l.getClass().getSimpleName();
        ps.append("scn=").append(scn).append(", n=").append(l.getName())
                .append(", uph=").append(String.valueOf(l.getUseParentHandlers()))
                .append(", l=").append(String.valueOf(l.getLevel()))
                .append(", fl=").println(l.getFilter());
        for (Handler h : l.getHandlers()) {
            ps.append("\t").append(l.getName()).append("->")
                    .append(h.getClass().getName()).append(", h=")
                    .append(String.valueOf(h.getLevel())).append(", fl=")
                    .append(String.valueOf(h.getFilter())).println();
        }
    }
}