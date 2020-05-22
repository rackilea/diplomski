public static void main(String[] args) {
    // Set the frame up
    frame = new JFrame();
    frame.setSize(400, 300);  // ** you really don't want to do this
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);

    // Get some more necessary objects
    s1 = new Ship();
    shoot = new Shoot();

    frame.add(shoot);  // ** added to GUI
    frame.setVisible(true);  // ** display GUI **after** addition