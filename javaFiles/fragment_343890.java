public void actionPerformed(ActionEvent e) {
  String shape = tf.getText();
  if (shape.equals("rectangle") || shape.equals("RECTANGLE"))
  {
    paintRec(null);//passing null value to a method which has Graphics class instance and using it for drawing
  }
  if (shape.equals("circle") || shape.equals("CIRCLE"))
  {
      paintCirc(null);//same here
  }
}