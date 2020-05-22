import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Tester extends JFrame {

    public Tester() {
        setTitle("Tester window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        createMainPanel();

        setVisible(true);
    }

    public static void main(String args[]) {
        Runnable runnable = new Runnable() {
            public void run() {
                new Tester();
            }
        };
        EventQueue.invokeLater(runnable);
    }

    private void createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(new CenterPanel(), BorderLayout.SOUTH);
        add(mainPanel);
    }

    private class CenterPanel extends JPanel {
        public CenterPanel() {
            // inner panel created to center the buttons in the center panel
            JPanel innerPanel = new JPanel(); // uss flow layout to center buttons
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));
            add(innerPanel);

            Random r = new Random();
            for (int i = 0; i < 5; ++i) {
                JButton button = new JButton(i + " button");
                button.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
                int width = 100;
                int height = r.nextInt(500)+20;
                Dimension d = new Dimension(width, height);

                button.setPreferredSize(d);
                button.setMaximumSize(d);
                // button.setMinimumSize(d);
                // button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
                innerPanel.add(button);
            }

        }
    }    
}