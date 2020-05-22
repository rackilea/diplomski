@SuppressWarnings("serial")
class TextFieldPanel extends JPanel {
    public static final String NAME = "TEXT_FIELD_PANEL";
    private JTextField textField = new JTextField(10);

    public TextFieldPanel() {
        add(textField);
    }

    public void textFieldRequestFocus() {
        textField.requestFocusInWindow();
    }
}