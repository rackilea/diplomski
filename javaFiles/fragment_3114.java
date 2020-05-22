/* 
   This is probably not the one you want
 */
  aTextArea.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
        }
        public void focusLost(FocusEvent e) {  
           if(aTextArea.getText().equals("1")) {
              System.out.println("Test Worls");
        }
  }});

  /*
    With this KeyListener
    The second someone types "1" in the text area
    It compares the strings, and the test works
  */
  aTextArea.addKeyListener(new KeyListener() {
     public void keyTyped(KeyEvent e) {
     }

     public void keyReleased(KeyEvent e) {
        String currentText = aTextArea.getText();
        if(currentText.equals("1")) {
           JOptionPane.showMessageDialog(null, "Test Works");
        }
     }

     public void keyPressed(KeyEvent e) {
     }

  });