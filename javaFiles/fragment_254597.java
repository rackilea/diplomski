...
public void keyPressed(KeyEvent e) {
     int key = e.getKeyCode();    

     if (key == KeyEvent.VK_ENTER) {
        inputString = textField.getText();
        textArea.append(inputString + "\n");
        textField.setText("");
        processInput(inputString); //crunch it
        }
}
....