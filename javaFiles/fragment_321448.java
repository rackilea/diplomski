public void keyPressed(KeyEvent e) {            
  if (e.getKeyChar() == KeyEvent.VK_ENTER) {
     if(logInAttempts == MAX_LOGIN_ATTEMPTS) {
        // they've failed to login too many times
        // lock them out, start a timer, or whatever
    } else {
     // go on to check if login is correct
    if (userTf.getText().equals(dat.getUserName()) & passTf.getText().equals(dat.getPassWord())) {
        JOptionPane.showMessageDialog(null,"Hello You are an Authorized User!!!",null,JOptionPane.INFORMATION_MESSAGE);         
        System.exit(1);          
    } else {
        // if using a flag for login attempts, you need to increment it
        // when the user fails logging in
        logInAttempts++;
        JOptionPane.showMessageDialog(null,"Incorrect Password or Username!!!",null,JOptionPane.WARNING_MESSAGE);               
    }           
}