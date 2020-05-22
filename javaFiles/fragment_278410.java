import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxStructAndJComponents {

    private JLabel intro = new JLabel("The chosen name:");
    private JFrame frame;    
    private JLabel name = new JLabel("JLabel");

    public BoxStructAndJComponents() {
        frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = createUI();
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel createUI() {
        intro = new JLabel("The chosen name:");
        intro.setLabelFor(name);
        final JButton button = new JButton("Pick a new name...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        intro.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        name.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(intro);
        panel.add(Box.createVerticalStrut(5));
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(150, 10)));
        panel.add(button);
        return panel;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BoxStructAndJComponents bb = new BoxStructAndJComponents();
            }
        });
    }
}