textField.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "backspace");
textField.getActionMap().put("backspace", new AbstractAction() 
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Component c = (Component)e.getSource();
            c.transferFocusBackward();
    }
});