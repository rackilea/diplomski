class MyFontChooser {
  private MyGui myGui;

  public MyFontChooser(MyGui myGui) {
    this.myGui = myGui;
  }

  // some event caused method
  public void changeFont() {
    myGui.setTextAreaFont(someFont);
  }