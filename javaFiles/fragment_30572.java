import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class World {

  private Rectangle[] blocks;
  private Image[] blockImg;
  private final int arrayNum = 500;

  //Block Images
  private Image BLOCK_GRASS, BLOCK_DIRT, BLOCK_STONE, BLOCK_SKY;

  private int x, y;

  public World(){
    BLOCK_GRASS = new ImageIcon(Frame1.class.getResource("images/openFile.gif")).getImage();
    BLOCK_DIRT = new ImageIcon(Frame1.class.getResource("images/openFile.gif")).getImage();
    BLOCK_STONE = new ImageIcon(Frame1.class.getResource("images/openFile.gif")).getImage();
    BLOCK_SKY = new ImageIcon(Frame1.class.getResource("images/openFile.gif")).getImage();
    blocks = new Rectangle[500];
    blockImg = new Image[500];

    loadArrays();
  }

  private void loadArrays()
  {
    for(int i = 0; i < arrayNum; i++)
    {
      if(x >= 500){
        x = 0;
        y += 20;
      }
      if(i >= 0 && i < 100)
      {
        blockImg[i] = BLOCK_SKY;
        blocks[i] = new Rectangle(x, y, 20, 20);
      }
      if(i >= 100 && i < 125)
      {
        blockImg[i] = BLOCK_GRASS;
        blocks[i] = new Rectangle(x, y, 20, 20);
      }
      if(i >= 125 && i < 225)
      {
        blockImg[i] = BLOCK_DIRT;
        blocks[i] = new Rectangle(x, y, 20, 20);
      }
      if(i >= 225 && i < 500)
      {
        blockImg[i] = BLOCK_STONE;
        blocks[i] = new Rectangle(x, y, 20, 20);
      }
      x += 20;

    }

  }

  public void draw(Graphics g)
  {
    for(int i = 0; i< arrayNum; i++){
      g.drawImage(blockImg[i], blocks[i].x, blocks[i].y, null);
    }
  }
}

class GamePanel extends JPanel implements Runnable {
  //Double buffering
  private Image dbImage;
  private Graphics dbg;
  //JPanel variables
  static final int GWIDTH = 500, GHEIGHT = 400;
  static final Dimension gameDim = new Dimension(GWIDTH, GHEIGHT);
  //Game variables
  private Thread game;
  private volatile boolean running = false;
  //Game Objects
  World world;

  public GamePanel(){
    world = new World();

    setPreferredSize(gameDim);
    setBackground(Color.WHITE);
    setFocusable(true);
    requestFocus();
    //Handle all key inputs from user
    addKeyListener(new KeyAdapter(){
      @Override
      public void keyPressed(KeyEvent e){

      }
      @Override
      public void keyReleased(KeyEvent e){

      }
      @Override
      public void keyTyped(KeyEvent e){

      }
    });

  }

  public void run(){
    while(running){
      gameUpdate();
//      gameRender();
//      paintScreen();
      repaint();

    }
  }

  private void gameUpdate(){
    if(running && game != null){

    }
  }

  private void gameRender(){
    if(dbImage == null){ // Create the buffer
      dbImage = createImage(GWIDTH, GHEIGHT);
      if(dbImage == null){
        System.err.println("dbImage is still null!");
        return;
      }else{
        dbg = dbImage.getGraphics();
      }
    }
    //Clear the screen
    dbg.setColor(Color.WHITE);
    dbg.fillRect(0, 0, GWIDTH, GHEIGHT);
    //Draw Game elements
    draw(dbg);
  }

  /* Draw all game content in this method */
  public void draw(Graphics g){
    world.draw(g);
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    gameRender();
    paintScreen(g);
  }
  private void paintScreen(Graphics g){
    try{
//      g = this.getGraphics();
      if(dbImage != null && g != null){
        g.drawImage(dbImage, 0, 0, null);
      }
      Toolkit.getDefaultToolkit().sync(); //For some operating systems
//      g.dispose();
    }catch(Exception e){
      System.err.println(e);
    }
  }

  public void addNotify(){
    super.addNotify();
    startGame();
  }

  private void startGame(){
    if(game == null || !running){
      game = new Thread(this);
      game.start();
      running = true;
    }
  }

  public void stopGame(){
    if(running){
      running = false;
    }
  }
}
class Main extends JFrame
{
  GamePanel gp;

  public Main()
  {
    gp = new GamePanel();
    setSize(500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(gp);
    setResizable(false);
    setVisible(true);
  }



  public static void main(String[] args)
  {
    Main m = new Main();
  }

}