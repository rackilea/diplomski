public static void main(String[] arg) {
  JFrame frame = new JFrame();
  JApplet applet = new Sw3();
  frame.getContentPane().add(applet);
  frame.pack();
  frame.setVisible(true);
  applet.init();
  applet.start();
}