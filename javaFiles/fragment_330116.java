public class Shake extends JComponent 
{
   private static final long serialVersionUID = 1L;
   private static Image logo = null;

   private static double SHAKE_MAX_X = 20;
   private static double SHAKE_MAX_Y = 20;

   private static double SHAKE_X = 0;
   private static double SHAKE_Y = 0;

   private static double SHAKE_TIME = 50;

   private static long ELAPSED_TIME = 0;
   private static long LAST_TIME = 0;

   private static Random rnd = new Random();

   public static void main(String[] args)
   {   
    logo = Toolkit.getDefaultToolkit().getImage("C:\\some_logo.jpg");

    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 640, 480);
    final Shake shake = new Shake();
    window.getContentPane().add(shake);
    window.setVisible(true);

    int delay = 20; //milliseconds
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            shake.repaint();
        }
    };
    new Timer(delay, taskPerformer).start();
   }

   public void paint(Graphics g)
   {
    super.paint(g);
    Graphics2D gpcs= (Graphics2D) g;

    updateShake();
    AffineTransform at = gpcs.getTransform();

    at.translate(SHAKE_X, SHAKE_Y);
    gpcs.setTransform(at);

    gpcs.drawImage(logo, 0, 40, 250, 75, null);
    gpcs.finalize();
   }

   public void updateShake()
   {
    ELAPSED_TIME += System.currentTimeMillis() - LAST_TIME;
    if (ELAPSED_TIME > SHAKE_TIME)
    {
        ELAPSED_TIME = 0;
        SHAKE_X = rnd.nextDouble() * SHAKE_MAX_X;
        SHAKE_Y = rnd.nextDouble() * SHAKE_MAX_Y;
    }

    LAST_TIME = System.currentTimeMillis();
   }
}