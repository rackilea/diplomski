Rectangle hitbox = new Rectangle(x,y,width,height);
//...
 if (e.getKeyCode() == KeyEvent.VK_LEFT){
   x = x - 10;
   hitbox.x = x;
   repaint();
// and so on for your various key events