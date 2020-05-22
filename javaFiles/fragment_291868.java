public class Main extends JPanel implements KeyListener 

    {

  private Point startPoint = new Point(0, 0);

  private Point endPoint = new Point(0, 0);

  public Main() 

  {
    addKeyListener(this);

  }

  public void keyPressed(KeyEvent evt) 

  {

    int keyCode = evt.getKeyCode();
    int d;

    if (evt.isShiftDown())
      d = 5;
    else
      d = 1;

    if (keyCode == KeyEvent.VK_LEFT)
      add(-d, 0);
    else if (keyCode == KeyEvent.VK_RIGHT)
      add(d, 0);
    else if (keyCode == KeyEvent.VK_UP)
      add(0, -d);
    else if (keyCode == KeyEvent.VK_DOWN)
      add(0, d);
  }

  public void keyReleased(KeyEvent evt)
  {
  }

  public void keyTyped(KeyEvent evt) 
  {

  }

  public boolean isFocusTraversable()

  {

    return true;

  }

  public void add(int dx, int dy) 

  {

    endPoint.x += dx;
    endPoint.y += dy;
    Graphics g = getGraphics();
    g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    g.dispose();
    startPoint.x = endPoint.x;
    startPoint.y = endPoint.y;

  }



public static void main(String[] args)

   {

    JFrame frame = new JFrame();
    frame.setTitle("Sketch");
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    contentPane.add(new Main());

    frame.setVisible(true);

  }

}