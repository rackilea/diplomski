public static void main(String[] args) {
    // Set the frame up
    frame = new JFrame();
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);

    // Get some more necessary objects
    s1 = new Ship();
    shoot = new Shoot();

    // Threads
    Thread ship = new Thread(s1);
    ship.start();
}