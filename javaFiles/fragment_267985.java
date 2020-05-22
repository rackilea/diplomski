import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Check extends JFrame {

    private static final long serialVersionUID = 1L;

    public void makeUI() {
        JFrame f = new JFrame();
        f.getContentPane().setBackground(new Color(107, 106, 104));
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(new Dimension(300, 200));
        f.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Check().makeUI();
            }
        });
    }
}