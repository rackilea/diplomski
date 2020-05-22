public class Platformer extends JPanel implements Runnable {

    int x = 0;//Sets the starting coords. of the ball
    int y = 0;

    public void add() {
            JFrame gameFrame = new JFrame("Sample Frame");//Makes the window variable w/ the name in quotations.
        Platformer game = new Platformer();//'Copies' the graphics functions above into a variable
        gameFrame.add(game);//Adds the above variable into th window
        gameFrame.setSize(setx,sety);//Sets the resolution/size of the window(x,y)
        gameFrame.setVisible(true);//Makse the window visible
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Makes the window close when the close button is hit
    }

      private void moveBall() {//How much the ball moves by
        x = x+1;
        y = y+1;
     }


     @Override
      public void paint(Graphics g) {//Essentially al the graphics functions
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }


     @Override
     public void run() {
        //this code will be executed for every 10 seconds
        moveBall();
        paint();
     }


    public static void main(String[] args) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter an x-value for the window (whole numbers only): ");
        int setx = reader.nextInt();
        System.out.print("Enter a y-value for the window (whole numbers only): ");
        int sety = reader.nextInt();

        JFrame gameFrame = new JFrame("Sample Frame");//Makes the window variable w/ the name in quotations.
        Platformer game = new Platformer();//'Copies' the graphics functions above into a variable
        gameFrame.add(game);//Adds the above variable into th window
        gameFrame.setSize(setx,sety);//Sets the resolution/size of the window(x,y)
        gameFrame.setVisible(true);//Makse the window visible
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Makes the window close when the close button is hit

        //schedule it to run for every 10 seconds
        //this calls the run() method above
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(game, 0, 10, TimeUnit.SECONDS);

    }    
}