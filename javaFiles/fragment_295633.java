public class App extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;

  public static void main(String[] a) {
    App app = new App();
    app.createControls();
  }

  public App() {
    setResizable(false);
    setTitle("OnFight.Combat_Arena_Beta");
    setSize(381, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
  }

  private void createControls() {
    JPanel upper = new JPanel();

    JButton fire = new JButton("Attack");
    fire.addActionListener(this);
    upper.add(fire);

    this.add(upper, BorderLayout.NORTH);
    setVisible(true);
  }

  /*
   * When the "Attack" button is pressed the time will start and the
   * circle will start painting.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    AttackFX attackfx = new AttackFX();

    this.add(attackfx, BorderLayout.CENTER);
    this.validate();
  }

  class AttackFX extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int xCoor = 100;
    private Timer t;

    public AttackFX() {
        t = new Timer(10, this);
        t.start();
    }


    public void paintComponent ( Graphics graphics ) {
        super.paintComponent ( graphics );
        Graphics2D graphics2d = ( Graphics2D ) graphics;

        graphics.setColor ( Color.cyan );
        graphics2d.fillOval(xCoor, 40, 8, 8);
    }

    /*
     * The timer will fire an action every 10 milliseconds, moving
     * our circle by 1 each time.
     * 
     * I unfortunately had to hard code a value that the circle should stop at
     * but I am sure you can find a way around this.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (xCoor > 250) {
            t.stop();
            setVisible(false);
        }

        xCoor++;
        repaint();
    }
  }
}