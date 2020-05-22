import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JPanel controlPanel = new JPanel(new FlowLayout(10));
                JPanel chatPanel = new JPanel();
                JPanel buttomsPanel = new JPanel();

                Panel panel = new Panel();

                panel.setBackground(Color.DARK_GRAY);
                panel.setSize(700, 700);
                GridLayout layout = new GridLayout(6, 6, 10, 10);

                panel.setLayout(layout);

                for (int i = 0; i < 36; i++) {
                    panel.add(new JButton(""));
                }
                controlPanel.add(panel);

                buttomsPanel.add(new JButton(""));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(buttomsPanel);
                frame.add(controlPanel, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}