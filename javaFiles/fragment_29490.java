import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @see https://stackoverflow.com/a/31223145/230513
 * @see https://stackoverflow.com/q/20815048/230513
 */
public class LoggerTest {

    private void display() {
        JFrame f = new JFrame("LoggerTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        f.add(new JButton("Button 1"));
        f.add(new JButton("Button 2"));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.ALL);
        logClass("java.awt.focus.Component");
        logClass("java.awt.focus.DefaultKeyboardFocusManager");
        EventQueue.invokeLater(new LoggerTest()::display);
    }

    private static void logClass(String name) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return name + ": " + record.getMessage() + '\n';
            }
        });
        Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
    }
}