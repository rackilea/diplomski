...
area.setEditable(false);

field = new JTextField(20);
field.addActionListener(new SendText());    
....

class SendText implements ActionListener{
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == field){
            String str = field.getText();
            if(!str.equals("")){
                commandHandler.handle(str);
            }
        }
    }
}