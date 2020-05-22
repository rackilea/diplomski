import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TwoFrames {

    public static void main(String[] args) {
        TwoFrames twoFrames = new TwoFrames();
        twoFrames.start();
    }

    private void start() {
        setupFrames();
    }

    JFrame frame1 = new JFrame("Frame 1"),
           frame2 = new JFrame("Frame 2");

    JLabel component1 = new JLabel("Click me 1"),
           component2 = new JLabel("Click me 2");

    private void setupFrames() {
        frame1.getContentPane().add(component1);
        frame2.getContentPane().add(component2);

        component1.setOpaque(true);
        component2.setOpaque(true);

        component1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame1.setVisible(false);
                frame2.setVisible(true);
            }
        });

        component2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame2.setVisible(false);
                frame1.setVisible(true);
            }
        });

        frame1.setSize(300, 300);
        frame2.setSize(400, 400);

        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(() -> frame1.setVisible(true));
    }
}