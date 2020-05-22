private int max_chrs = 256;

textarea.addKeyListener(new KeyListener(){
    @Override
    public void keyPressed(KeyEvent e){
         if(textarea.getText().length() >= this.max_chrs){
             e.consume();
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
         label.setText( Integer.toString(this.max_chrs - textarea.getText().length()) );
    }
});