import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimplePanel implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame("JPanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.CYAN);
        colorPanel.setPreferredSize(new Dimension(300, 300));

        frame.add(colorPanel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimplePanel());
    }

}