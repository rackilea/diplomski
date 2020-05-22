public interface TextWrangler {
    public void addActionListener(ActionListener listener);
    public void removeActionListener(ActionListener listener);
    public String getText();
}

public class FirstFrame extends JFrame implements TextWrangler {
    private JButton textButton;
    private JTextField textField;

    /*...*/

    public void addActionListener(ActionListener listener) {
        textButton.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        textButton.removeActionListener(listener);
    }

    public String getText() {
        return textField.getText();
    }
}

public class SecondFrame extends JFrame {
    private JLabel textLabel;
    private JTextField textField;
    private TextWrangler textWrangler;

    public SecondFrame(TextWrangler wrangler) {
        textWrangler = wrangler;
        wrangler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textLabel.setText(textWrangler.getText());
            }
        });
        /*...*/
    }
}