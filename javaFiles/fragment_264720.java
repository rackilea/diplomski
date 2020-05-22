public void framemade()
{
    System.out.println("Frame starting");
    //Frame is created here 
    JFrame frame = new JFrame();
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setTitle("Animation");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Window w = frame;
    w.addKeyListener(this);
    frame.add(c); // Change this line
}