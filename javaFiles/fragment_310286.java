// TODO: delete this method
public void paintComponent(Graphics g) {
  System.out.println("paintComponent");
  // super.paintComponents(g); // *** !! No -- this is not the super method ***
  super.paintComponent(g);
  if (to != null) {
     int i = to.getValue();
     System.out.println("paintComponent " + i);

     // of course you'll never set a JLabel's text from within this method
     jLabel1.setText(String.valueOf(i));
     jLabel2.setText(String.valueOf(i + 1));
  }
}