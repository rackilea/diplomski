LaserBallMain laserBallMain = new LaserBallMain();

JFrame frame = new JFrame();
frame.setLayout(new GridLayout(1, 1));
frame.add(laserBallMain);

// Set frame size and other properties
...

// Call applet methods
laserBallMain.init();
laserBallMain.start();

frame.setVisible(true);