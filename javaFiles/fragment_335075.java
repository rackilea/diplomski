JFrame frame = new JFrame("Press Your Luck");
     frame.setSize(sizeX, sizeY);
     frame.setLocation(locX, locY);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setContentPane(new Panel1());
     frame.setVisible(true);