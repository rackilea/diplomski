import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class SimpleExampleWithComponents extends JPanel {
    private static final int COLS = 15;
    private JTextField nameField = new JTextField(COLS);
    private JTextField amountField = new JTextField(COLS);
    private JButton submitButton = new JButton("Submit");

    private JLabel payeeLabel = new JLabel("           ");
    private JLabel amountLabel = new JLabel("$         ");

    public SimpleExampleWithComponents() {
        SubmitListener submitListener = new SubmitListener();
        nameField.addActionListener(submitListener);
        amountField.addActionListener(submitListener);
        submitButton.addActionListener(submitListener);
        submitButton.setMnemonic(KeyEvent.VK_S);

        JPanel topPanel  = new JPanel();
        topPanel.add(new JLabel("Name:"));
        topPanel.add(nameField);
        topPanel.add(Box.createHorizontalStrut(15));
        topPanel.add(new JLabel("Amount:"));
        topPanel.add(amountField);
        topPanel.add(Box.createHorizontalStrut(15));
        topPanel.add(submitButton);

        // holds one row and 3 columns
        JPanel middlePanel = new JPanel(new GridLayout(1, 3));
        middlePanel.add(new JLabel("Pay to the order of:"));
        middlePanel.add(payeeLabel);
        middlePanel.add(Box.createHorizontalStrut(15));
        middlePanel.add(amountLabel);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(middlePanel, BorderLayout.CENTER);
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String amount = amountField.getText().trim();

            payeeLabel.setText(name);
            amountLabel.setText("$" + amount);
        }
    }

    private static void createAndShowGui() {
        SimpleExampleWithComponents mainPanel = new SimpleExampleWithComponents();

        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}