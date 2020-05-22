class FarbListener implements ActionListener{
  private final JFrame frameToWorkOn;
  private final Color colorToSet;

  FarbListener(JFrame frameToWorkOn, Color colorToSet){
    this.frameToWorkOn = frameToWorkOn;
    this.colorToSet = colorToSet;
 }

 public void actionPerformed(ActionEvent e) {
   frameToWorkOn.setBackground(colorToSet);
 }