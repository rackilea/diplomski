public class Paint extends JPanel implements ActionListener {
    Mouse swim = new Mouse();
    Timer tm = new Timer(7, this);
    public void paintComponent(Graphics g) {
    // Try this:
    ImageIcon swimminghold = new ImageIcon(render.class.getResource("resources/Swimmingpoolns.png")); 
    swimmingpool = swimminghold.getImage();
    JLabel label = new JLabel();
    label.setIcon(swimminghold);
    label.addMouseMotionListener(swim);
    addMouseMotionListener(swim);
    label.addMouseMotionListener(swim);
    addMouseMotionListener(swim);

        //Do something

        /* ...*/
}