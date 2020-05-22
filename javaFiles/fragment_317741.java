AbstractAction action = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            button.doClick();                
        } else if(e.getSource() instanceof JComponent){
            JComponent component = (JComponent) e.getSource();
            component.transferFocus();
        }
    }
};

JTextField textField1 = new JTextField();
textField1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
textField1.getActionMap().put("TransferFocus", action);

JTextField textField2 = new JTextField();
textField2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
textField2.getActionMap().put("TransferFocus", action);

JButton button1= new JButton();
button1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
button1.getActionMap().put("Enter", action);