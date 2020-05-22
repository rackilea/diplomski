import java.awt.*;
import javax.swing.*;

public class AwtSwing {

    private JPanel panel = new JPanel(new GridLayout(8, 8, 10, 10));

    public AwtSwing() {
        for (int i = 0; i < 36; i++) {
            Canvas cnv = new Canvas();
            JPanel panelInner = new JPanel(new BorderLayout());
            panelInner.add(cnv, BorderLayout.CENTER);
            panel.add(panelInner);
        }
        JFrame f = new JFrame("JTableExample");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(new JScrollPane(panel), BorderLayout.CENTER);
        f.pack();
        f.setLocation(150, 150);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                AwtSwing awtSwing = new AwtSwing();
            }
        });
    }
}