import javax.swing.*;

public class Application {

    private JFrame frame;
    private CustomPanel panel;

    public Application() {
        frame = new JFrame();
        // next 2 lines, just a good idea
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // at 50x50, the title bar on Windows is wider!
        panel = new CustomPanel(200, 200);
        frame.add(panel);
        // make the frame smallest it can be and still show components
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new Application();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class CustomPanel extends JPanel {

    public CustomPanel(int w, int h) {
        setPreferredSize(new java.awt.Dimension(w, h));
    }
}