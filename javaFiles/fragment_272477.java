import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class AccessVariable extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private JLabel myLabel = new JLabel();
    private JTextField textField = new JTextField(10);

    public AccessVariable() {
        add(textField);
        add(myLabel);

        textField.addActionListener(new MyListener());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            myLabel.setText("Text is: " + text);

            textField.requestFocusInWindow();
            textField.selectAll();
        }
    }

    private static void createAndShowGui() {
        AccessVariable mainPanel = new AccessVariable();

        JFrame frame = new JFrame("Access Variable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}