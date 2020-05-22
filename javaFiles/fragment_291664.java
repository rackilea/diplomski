public void actionPerformed(ActionEvent event){

    String string = "";

    if(event.getSource()==item1) 
        String.format("field1: %s", event.getActionCommand());
    else if(event.getSource()==item2)
            String.format("field2: %s", event.getActionCommand());
    else if(event.getSource()==item3)
            String.format("field3: %s", event.getActionCommand());
    else if(event.getSource()==password)
            String.format("Password Field: %s", event.getActionCommand());

    JOptionPane.showMessageDialog(null, string);
}