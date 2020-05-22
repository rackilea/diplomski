import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import com.apple.eawt.Application;

public class Test {

    public static void main(String[] args) {
        try {
            Application application = Application.getApplication();
            application.setDockIconImage(ImageIO.read(Test.class.getResource("/javaapplication163/bunny.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        public TestPane() {
            add(new JLabel("Hello"));
        }

    }

}