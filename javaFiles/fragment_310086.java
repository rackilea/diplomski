public class Game extends JFrame {
  //make this static and public so it can be accessed anywhere.
  public static int x, y;
  ...
  }
  ...
  public void keyPressed(KeyEvent e){
    int keyCode = e.getKeyCode();

    if(keyCode == e.VK_W)
      Game.y--; //Static access
  }