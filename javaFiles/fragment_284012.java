if (e.getKeyCode()==10){

    //If key pressed is enter.  
        client.send(userChatBox.getText());
        userChatBox.setCaretPosition(0);
        userChatBox.setText("");
        e.consume();
}