import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class LabelHTMLAutoResize {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel p = new JPanel(new BorderLayout());
                JLabel l = new JLabel("<html><p> Some verrrry long text  Some verrrry long  Some verrrry long text dsa ads oiosi o</p>");
                l.setVerticalAlignment(SwingConstants.TOP);
                l.setOpaque(true);
                l.setBackground(Color.green);
                p.add(l);
                f.setContentPane(p);
                /* good practice is to use f.pack(); and let the size be automatically calculated but we want to show line wrapping thus frame size is set */
                f.setSize(200, 200);
                f.setVisible(true);
            }
        });
    }
}