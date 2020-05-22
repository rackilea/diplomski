JButton newButton = new JButton("New Message");
newButton.addActionListener(this);
this.add(newButton);

public void newMessage() {
System.out.println(in.readObject().toString);
}


public void actionPerformed(ActionEvent ae) {
    if (ae.getSource().equals(newButton)) {
        newMessage();    
    }  
}