BufferedImage img = ...;

JTextPane pane = new JTextPane();
pane.setContentType("text/html");

String url = saveImageToCache(pane, img, "image1");

pane.setText("<html><body><img src=\"" + url + "\"></body></html>");

JFrame frame = new JFrame("image test");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(pane);
frame.setSize(img.getWidth(), img.getHeight());
frame.setLocationRelativeTo(null);
frame.setVisible(true);