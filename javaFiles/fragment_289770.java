class FieldHandler implements ActionListener{

    public void actionPerformed(ActionEvent event)  {
        if (event.getSource() == submit){
            String user = usr.getText(); 
            // or String user = LoginPanel.this.usr.getText(); 
            char[] password = pass.getPassword();
            // do whatever you want with the user and password
        }
        ...
    }

}