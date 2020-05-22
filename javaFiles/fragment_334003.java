private class MyButtonHandler implements ActionListener{

    public void actionPerformed(ActionEvent event){
        JOptionPane.showMessageDialog(TextPassWordEvent.this, "This only gets shown when the button gets pressed because I only added an instance of this action listener to button and none of the other components");
    }
}