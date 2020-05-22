public Testwork() {

      setPreferredSize(new Dimension(1000, 700));
      Timer timer = new Timer(0, this);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.add(this);
      // sizes the frame and jpanel and organizes the components.
      frame.pack();
      // centers the window in the screen
      frame.setLocationRelativeTo(null);
      // sets the delay in milliseconds
      timer.setDelay(100);
      // starts the timer
      timer.start();
   }