import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("Closing");
                        System.exit(0);
                    }
                });
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                try {
                    Class quitStrategies = Class.forName("com.apple.eawt.QuitStrategy");
                    Object quitStrategy = null;
                    for (Object o : quitStrategies.getEnumConstants()) {
                        if ("CLOSE_ALL_WINDOWS".equals(o.toString())) {
                            quitStrategy = o;
                        }
                    }
                    if (quitStrategy != null) {
                        Class appClass = Class.forName("com.apple.eawt.Application");
                        Class params[] = new Class[]{};

                        Method getApplication = appClass.getMethod("getApplication", params);
                        Object application = getApplication.invoke(appClass);
                        Method setQuitStrategy = application.getClass().getMethod("setQuitStrategy", quitStrategies);
                        setQuitStrategy.invoke(application, quitStrategy);
                    }

                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {
    }
}