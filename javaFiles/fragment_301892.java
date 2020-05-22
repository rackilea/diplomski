import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class FullScreen {

    private static final long serialVersionUID = 1L;
    private GraphicsDevice device;
    private JButton button = new JButton("Close Meeee");
    private JPanel myPanel = new JPanel();
    private JFrame frame = new JFrame();

    public FullScreen() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        myPanel.setFocusable(true);
        myPanel.add(button);
        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("ENTER"), "clickENTER");
        frame.getRootPane().getActionMap().put("clickENTER", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                exitFullScreen();
            }
        });
        enterFullScreen();
        frame.setVisible(true);

        // code line for @MOD 
        // from http://stackoverflow.com/questions/15152297/how-to-get-extendedstate-width-of-jframe

        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                System.out.println(frame.getBounds());
            }
        };
        SwingUtilities.invokeLater(doRun);
    }

    private void enterFullScreen() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphicsEnvironment.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(frame);
            frame.validate();
        }
    }

    private void exitFullScreen() {
        device.setFullScreenWindow(null);
        myPanel.setPreferredSize(new Dimension(400, 300));
        frame.pack();
    }

    public static void main(String[] args) {
        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                FullScreen fullScreen = new FullScreen();
            }
        };
        SwingUtilities.invokeLater(doRun);
    }
}