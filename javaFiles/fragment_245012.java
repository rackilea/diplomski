import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class TextPaneDemo {
    private static void createAndShowGUI() {
        final JTextPane pane = new JTextPane();
        pane.setText("Some text");

        JButton buttonButton = new JButton("Insert label");
        buttonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JLabel label = new JLabel("label");
                label.setAlignmentY(0.85f);
                pane.insertComponent(label);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(buttonButton, BorderLayout.SOUTH);
        panel.add(pane, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}