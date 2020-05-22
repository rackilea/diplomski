public class SeparateClassView extends JPanel {
    private JTextField field1 = new JTextField(12);
    private JTextField field2 = new JTextField(12);
    private JTextField resultField = new JTextField("false", 5);
    private JButton button = new JButton("Click");

    public SeparateClassView() {
        resultField.setEditable(false);
        resultField.setFocusable(false);

        add(new JLabel("Field 1:"));
        add(field1);
        add(new JLabel("Field 2:"));
        add(field2);

        add(button);

        add(new JLabel("Two texts equivalent?:"));
        add(resultField);

    }

    public void addButtonListener(ActionListener listener) {
        button.addActionListener(listener);
        field1.addActionListener(listener);
        field2.addActionListener(listener);
    }

    public String getField1Text() {
        return field1.getText();
    }

    public String getField2Text() {
        return field2.getText();
    }

    public void setField1Text(String text) {
        field1.setText(text);
    }

    public void setField2Text(String text) {
        field2.setText(text);
    }

    public void setResult(boolean result) {
        resultField.setText(String.valueOf(result));
    }
}