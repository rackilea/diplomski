import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FormTTS extends JFrame {
    private boolean isFullScreen = false;
    private JButton button;

    public FormTTS() {
        initComponents();
        initFullScreen();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        button = new JButton(
                "I'm a smallbutton in a Huge Frame, what the heck?!");
        add(button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initFullScreen() {
        GraphicsEnvironment env = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        isFullScreen = device.isFullScreenSupported();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(isFullScreen);
        setResizable(!isFullScreen);
        if (isFullScreen) {
            // Full-screen mode
            device.setFullScreenWindow(this);
            validate();
        } else {
            // Windowed mode
            this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormTTS().setVisible(true);
            }
        });
    }
}