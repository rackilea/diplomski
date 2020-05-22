button.addActionListener(this);

    button.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_ENTER) {
              onButtonPress();
         }
    } 
 });

public void actionPerformed (ActionEvent e) {
    if (e.getSource() == button){
       onButtonPress();
    } 
 }

private void onButtonPress(){
    // do something
}