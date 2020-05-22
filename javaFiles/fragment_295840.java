GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gd = ge.getDefaultScreenDevice();
GraphicsConfiguration gc = gd.getDefaultConfiguration();
Rectangle bounds = gc.getBounds();

JFrame f = new JFrame();
f.setUndecorated(true);
f.setBounds(bounds);
f.setVisible(true);