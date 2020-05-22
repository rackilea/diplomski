addKeyListener(new KeyAdapter(){
  public void keyPressed(KeyEvent e){
    text+=e.getKeyChar();

    //you might not need this is you are rendering constantly
    repaint();
  }
});