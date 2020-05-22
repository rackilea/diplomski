import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AnimatedButton {

    public static void main(String[] args) {
        new AnimatedButton();
    }

    public AnimatedButton() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
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

        private ImageIcon animatedGif;

        public TestPane() {
            setLayout(new GridBagLayout());
            JButton btn = new JButton(new ImageIcon("WildPony.png"));
            btn.setRolloverEnabled(true);
            animatedGif = new ImageIcon("ajax-loader.gif");
            btn.setRolloverIcon(animatedGif);
            add(btn);

            btn.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    animatedGif.getImage().flush();
                }

            });
        }    
    }
}