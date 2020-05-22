class TextFieldFocusListener implements FocusListener
{
    public void focusGained(FocusEvent etffl)
    {
        JTextField textField = (JTextField)etffl.getComponent();
        textField.setCaretPosition(textField.getDocument().getLength());
    }

    public void focusLost(FocusEvent etffl)
    {
        JTextField textField = (JTextField)etffl.getComponent();
        textField.setCaretPosition(0);
    }
}