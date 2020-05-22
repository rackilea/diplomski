class Play extends JFrame implements ActionListener {

private int _xPad,_yPad,_xdir,_ydir;
private Rectangle[][] _bricks;
//    private Ball _gameBall;
private javax.swing.Timer _timer;
Image im;

public Play(){
    super("Elemental Brick Breaker");
    setSize(1000, 500);
    _xdir = 0;
    _ydir = 0;
    _xPad = 350;
    _yPad = 500;
    _timer = new javax.swing.Timer(1000,this);
    _timer.start();
//        _gameBall = new FireBall(_xPad,_yPad);
    _bricks = new Rectangle[8][10];
    int x = 75, y = 40;
    for(int i = 0 ; i < 8 ; i++) {
        for(int j = 0 ; j < 10 ; j++) {
            _bricks[i][j] = new Rectangle(x,y, 60, 20);
            x = x + 65;
            }
        y = y + 25;
        x = 75;
    }
    setVisible(true);
    im=createImage(getWidth(), getHeight());
}

public void paint(Graphics g) {
    Graphics g2=im.getGraphics();
    g2.fillRect(_xPad, _yPad, 120, 10);
    for(int i = 0 ; i < 8 ; i++) {
        for(int j = 0 ; j < 10 ; j++) {
            g2.fillRect(_bricks[i][j].x, _bricks[i][j].y , 60, 20);
            }
    }
    g.drawImage(im, 0, 0, this);
}

public void update(Graphics g) { paint(g); }

@Override
public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
  repaint();
  System.out.println("t");
}
}