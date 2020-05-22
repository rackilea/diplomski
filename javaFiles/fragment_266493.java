import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.SwingConstants;

    @SuppressWarnings("serial")
    public class Popup extends JPanel {

        public static void main(String[] args) {
            Popup a = new Popup();
            a.popup("Title", "Message");
        }

        public void popup(String title, String message) {
            String markup = "<html><font color=#0033CC size=+1>" + message + "</html>";
            JLabel l = new JLabel(markup);
            l.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel p = new JPanel(new java.awt.GridLayout(0, 1));
            p.add(l);
            JFrame f = new JFrame(title);
            f.setContentPane(p);
            f.setSize(600, 200);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() < (startTime + 5000)) {
                f.setVisible(true);
            }
            f.setVisible(false);
            f.dispose();
            f = null;
        }
    }