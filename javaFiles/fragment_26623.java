public class MyListener implements ActionListener {
  private Main main;

  public MyListener(Main main) {
    this.main = main;
  }

  public void actionPerformed(ActionEvent e) {
     // now in here we can call methods on the main variable
     // and it will be called on the actual displayed main
  }
}