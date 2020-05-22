import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** @see http://stackoverflow.com/questions/5136859 */
public class ColorLabel extends JLabel {

    private static final int N = 10;
    private static final Random random = new Random();
    private static final MouseAdapter listener = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {
            ColorLabel label = (ColorLabel) e.getSource();
            label.setBackground(new Color(random.nextInt()));
        }
    };

    public ColorLabel() {
        this.setOpaque(true);
        this.setBackground(new Color(random.nextInt()));
        this.setPreferredSize(new Dimension(32, 32));
        this.addMouseListener(listener);
    }

    private void displayGrid() {
        JFrame f = new JFrame("ColorGrid");
        f.setLayout(new GridLayout(N, N));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < N * N; i++) {
            final ColorLabel label = new ColorLabel();
            f.add(label);
        }
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ColorLabel().displayGrid();
            }
        });
    }
}