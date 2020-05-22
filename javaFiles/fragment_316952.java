class FinalGame extends Canvas
{

private static final long  serialVersionUID   =1L;
//refers to players coordinates
static int x=230, y=230;
static boolean coin1=true;
static int coinsCollected=0;
static int mj;
static boolean bounce=true;
Red r;
Coin c;
public FinalGame() {
    setSize(new Dimension(500, 500));
    setBackground(Color.black);
    addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            moveSquare(e);
        }
    });
    r=new Red(this);
    r.start();
    c=new Coin(this);
    c.start();      
}

public void paint(Graphics g)
    {
        if(x==r.x && y==r.y) System.exit(0);

        if(c.visible) {
          g.setColor(Color.yellow);
          g.fillOval(c.c1x, c.c1y, 20, 20);
        }

        g.setColor(Color.white);
        g.fillRect(x,y,20,20);

        g.setColor(Color.red);
        g.fillRect(r.x, r.y, 20, 20);

    }

public void moveSquare(KeyEvent e)
    {

        switch(e.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
                y += 5;
                break;
            case KeyEvent.VK_UP:
                y-= 5;
                break;
            case KeyEvent.VK_LEFT:
                x-=5;
                break;
            case KeyEvent.VK_RIGHT:
                x+=5;
                break;
        }

        repaint();
    }

public void m()
    {
            JFrame frame = new JFrame("Basic Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(this);
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);
            requestFocus();

    }

class Coin extends Thread {
  int c1x=20, c1y=20;
  boolean visible=true;
  FinalGame f;

  public Coin(FinalGame f) {
    this.f=f;
  }

  public void run() {

    while(true)
    {       

        if((f.x==c1x)&&(c1y==20))
        {
                visible=false;

        }               
    }


  }
}


class Red extends Thread {
  int x=130, y=10;
  FinalGame f;

  public Red(FinalGame f) {
    this.f=f;
  }

  public void run() {

            int mj=5;

            while(true)
                {       

                    if((y==480)||(y==0))
                        {
                            mj=-mj;
                        }

                    y=y+mj;

    f.repaint();

    try
    {
            Thread.sleep(15);
    } catch (InterruptedException e)
    {
            e.printStackTrace();
    }

  }


  }
}