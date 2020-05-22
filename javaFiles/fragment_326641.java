boolean isTyping = false;

sm.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMsg(sm.getText(), "message", atName);
            sm.setText(null);
            isTyping = false;
        } else { // Typing
            if (isTyping) {
                if (sm.getText().length() == 0) {
                    isTyping = false;
                    // Send a message indicating the user has stopped typing
                    sendMsg("", "stopTyping", atName); //Customize the message type here, may need to adjust the server
                }
            } else {
                isTyping = true;
                sendMsg("", "typing", atName);
            }
        }
    }
});