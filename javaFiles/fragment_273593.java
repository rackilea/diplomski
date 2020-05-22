import com.apple.eawt.Application;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestMacIcon {

    public static void main(String[] args) {
        new TestMacIcon();
    }

    public TestMacIcon() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            final Application application = Application.getApplication();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        System.out.println("clicked");
                        application.requestUserAttention(true);
                        application.setDockIconImage(ImageIO.read(getClass().getResource("/Java.png")));
                        application.setDockIconBadge("Blah");
                        application.requestUserAttention(true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            Timer time = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!SwingUtilities.getWindowAncestor(TestPane.this).hasFocus()) {
                        ((Timer)e.getSource()).stop();
                        System.out.println("Pay attention!!");
                        application.requestUserAttention(true);
                    }
                }
            });
            time.setRepeats(true);
            time.setCoalesce(true);
            time.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}