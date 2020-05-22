TextAction digit = new TextAction()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        JTextComponent textField = getFocusedComponent();
        textField.replaceSelection( button.getText() );
    }
}

JButton button0 = new JButton("0");
button0.addActionListener(digit);
JButton button1 = new JButton("1");
button1.addActionListener(digit);