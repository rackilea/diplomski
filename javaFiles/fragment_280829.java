import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;

public class BackgroundImage {

    private static final String IMG = "http://i.stack.imgur.com/JEoYs.jpg";
    private final Border whiteLine = BorderFactory.createLineBorder(Color.LIGHT_GRAY);


    private void init() throws Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent background = new BackgroundComponent(new ImageIcon(new URL(IMG)));
        background.setLayout(new BorderLayout());
        background.add(bottomPanel(), BorderLayout.SOUTH);
        f.setContentPane(background);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel bottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        BoxLayout layout = new BoxLayout(bottomPanel, BoxLayout.X_AXIS);
        bottomPanel.setLayout(layout);
        bottomPanel.setOpaque(false);
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(loginPanel());
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(infoPanel());
        return bottomPanel;
    }

    private JPanel infoPanel() {
        JPanel pInfo = new JPanel(new GridBagLayout());
        pInfo.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pInfo.setBackground(Color.green);
        pInfo.setMaximumSize(new Dimension(200, 100));
        pInfo.setPreferredSize(new Dimension(200, 100));
        pInfo.setBorder(whiteLine);
        return pInfo;
    }

    private JPanel loginPanel() {
        JPanel pLogin = new JPanel(new GridBagLayout());
        pLogin.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pLogin.setBackground(Color.cyan);
        pLogin.setPreferredSize(new Dimension(400, 250));
        pLogin.setMaximumSize(new Dimension(400, 250));
        pLogin.setBorder(whiteLine);
        return pLogin;
    }

    class BackgroundComponent extends JComponent {

        public ImageIcon background;

        public BackgroundComponent(ImageIcon background) {
            this.background = background;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(background.getIconWidth(), background.getIconHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background.getImage(),
                    0, 0,
                    background.getIconWidth(),
                    background.getIconHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new BackgroundImage().init();
            } catch (Exception ex) {
            }
        });
    }
}