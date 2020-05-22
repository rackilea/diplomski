import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DynamicComponentAddition {

    private JFrame frame;
    private JPanel compPanel;
    private JLabel label;
    private JButton button; 

    private GridBagConstraints gbc;

    private int counter;

    public DynamicComponentAddition() {
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        counter = 0;
    }

    private void displayGUI() {
        frame = new JFrame("Dynamic component addition");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout(5, 5));

        compPanel = new JPanel(new GridBagLayout());
        button = new JButton("Add Component");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                final JLabel label = new JLabel(
                        Integer.toString(counter), JLabel.CENTER);
                addComp(compPanel, label, counter++);
            }
        });

        contentPane.add(compPanel, BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void addComp(JPanel panel, JComponent comp, int gridy) {
        gbc.gridy = gridy;      
        panel.add(comp, gbc);
        frame.pack();
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new DynamicComponentAddition().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}