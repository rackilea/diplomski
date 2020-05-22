import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Application {

    private JFrame frame;
    private JPanel containerPane;
    private JPanel topPane;
    private JPanel bottomPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Application().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("Example of 2 panels");
        containerPane = new JPanel();
        topPane = new JPanel();
        bottomPane = new JPanel();

        containerPane.setLayout(new GridLayout(2, 1));
        topPane.setLayout(new GridLayout(1, 2));
        bottomPane.setLayout(new BorderLayout());

        topPane.add(new JLabel("Left side"));
        topPane.add(new JLabel("Right side"));

        bottomPane.add(new JLabel("Left side"), BorderLayout.WEST);
        bottomPane.add(new JLabel("Right side"), BorderLayout.EAST);

        topPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Using GridLayout"));
        bottomPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Using BorderLayout"));

        containerPane.add(topPane);
        containerPane.add(bottomPane);

        frame.add(containerPane);

//      frame.pack();
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}