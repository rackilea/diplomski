public class MovingCircle extends JFrame implements ActionListener{
    Ellipse2D.Double myEllipse;
    Rectangle2D.Double backgroundRectangle;
    private int paintCount = 0;
    private int speed = 500;
    private Timer tmr;

    public MovingCircle() {
        //Make the ellipse at the starting position
        myEllipse = new Ellipse2D.Double( 30, 30, 20, 20 );

        //Make the background rectangle to "erase" the screen
        backgroundRectangle = new Rectangle2D.Double( 0, 0, 400, 300 );

        this.tmr = new Timer(500, this);
        tmr.start();
    }

    public static void main(String[] args ) {
        MovingCircle b = new MovingCircle();
        b.setSize( 400, 300 );
        b.setVisible(true);
        b.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public void actionPerformed( ActionEvent ae ) {
        //This will be called by the Timer
        myEllipse.setFrame( myEllipse.getX()+1, myEllipse.getY()+1, myEllipse.getWidth(), myEllipse.getHeight());   //Move 1 x-pixel and 1 y-pixel every 50 milliseconds
        repaint();
    }

    public void paint(Graphics g) {
        paintCount++;     // Incremenets by one for every repaint().
        System.out.println(paintCount);

        if(paintCount % 25 == 0){
            tmr.setDelay((int)(speed / 2));
            speed = (int)(speed / 2);
            System.out.println(speed);
        }

        int isPaintTen = (int)(paintCount / 10);  // Divid current count by 10.
        Graphics2D g2 = (Graphics2D)g;
        if((isPaintTen % 2) == 0){       // Take modulus to set if #/10 is odd or even.
            g2.setColor( Color.YELLOW );
            g2.fill( backgroundRectangle );
            g2.setColor( Color.RED );
            g2.draw( myEllipse );

        } else if((isPaintTen % 2) == 1) {
            g2.setColor( Color.RED );
            g2.fill( backgroundRectangle );
            g2.setColor( Color.YELLOW);
            g2.draw( myEllipse );    
        }
    }
}