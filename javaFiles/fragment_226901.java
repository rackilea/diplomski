import java.awt.event.*;
import javax.swing.*;

public final class MinimalSwingApplication {
    public static void main(String... aArgs) {
        MinimalSwingApplication app = new MinimalSwingApplication();
        app.buildAndDisplayGui();
    }

    private void buildAndDisplayGui() {
        JFrame frame = new JFrame("Main window");
        buildContent(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void buildContent(JFrame aFrame) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Hello"));
        JButton ok = new JButton("Show pop-up dialog");
        ok.addActionListener(new ShowDialog(aFrame));
        panel.add(ok);
        aFrame.getContentPane().add(panel);
        throw new RuntimeException("Oops!");
    }

    private static final class ShowDialog implements ActionListener {
        private JFrame fFrame;

        ShowDialog(JFrame aFrame) {
            fFrame = aFrame;
        }

        public void actionPerformed(ActionEvent aEvent) {
            JOptionPane.showMessageDialog(fFrame, "I am the a pop-up dialog");
            throw new RuntimeException("Something unexpected happened here");
        }
    }
}