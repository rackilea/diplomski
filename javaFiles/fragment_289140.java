final JTextField myTextField = new JTextField();
myTextField.addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent keyEvent) {

      }

      public void keyReleased(KeyEvent keyEvent) {
// Here write the comparison logic
                 if (Integer.parseInt(myTextField.getText()) > 100){
                     myTextField.setText(""); // Make it blank
                 }
      }

      public void keyTyped(KeyEvent keyEvent) {
      }
    });