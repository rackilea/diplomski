// inside of an ActionListener
public void actionPerformed(ActionEvent evt) {
  // this will get you a reference to the button object that was pressed:
  AbstractButton sourceBtn = (AbstractButton) evt.getSource();

  // now you can use the sourceBtn object, or compare its reference to your 
  // JButton variables or collections in your GUI
  // for example if your GUI has buttons in a List<JButton> you could
  for (JButton button : buttonList) {
    if (sourceBtn == button) {
      // you've found your button of interest!
    }
  }
}