import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Maze {
    private JFrame frame = null;

    public Maze(int length) {

        frame = new JFrame();

        JPanel panel = new JPanel(new GridLayout(length, length, 5, 5)) {
            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }
        };

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                JPanel p2 = new JPanel();
                p2.setBackground(Color.red);

                panel.add(p2);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Maze Game");
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setPanelColor(int index) {
        frame.getContentPane().getComponents()[index].setBackground(Color.GREEN);
    }

    public static void main(String[] a) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }
                Maze maze = new Maze(4);
                maze.setPanelColor(6);
            }
        });
    }
}