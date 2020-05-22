public class KeyInput extends KeyAdapter {
  Game game; //need a pointer to the original class object that holds x and y. Save it here
  public KeyInput(Game g){ //get the object pointer when this class is created.
    this.game = g;
  }

  public void keyPressed(KeyEvent e){
    int keyCode = e.getKeyCode();

    if(keyCode == e.VK_W)
       game.y--; //now a local variable we can access
  }
}


public class Game extends JFrame {
  //make these public
  public int x, y;

  //Constructor
  public Game(){
    setTitle("Game");
    setSize(300, 300);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.addKeyListener(new KeyInput(this)); //pass the pointer in here 
...