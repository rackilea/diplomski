textField.addKeyListener(new KeyAdapter(){
    @Override
    public void keyPressed(KeyEvent e){
         message = textField.getText();
         repaint();
    }
});