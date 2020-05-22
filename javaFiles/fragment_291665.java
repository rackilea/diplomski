public void actionPerformed(ActionEvent event){

    String string = "";

    if(event.getSource()==item1) {
        string = String.format("field1: %s", item1.getText())
    }
    else if(event.getSource()==item2) {
        string = String.format("field2: %s", item2.getText());
    }
    else if(event.getSource()==item3) {
        string = String.format("field3: %s", item3.getText());
    }
    else if(event.getSource()==password) {
        string = String.format("Password Field: %s", new String(password.getPassword()));
    }

    JOptionPane.showMessageDialog(null, string);
}