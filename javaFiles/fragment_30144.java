private MyFrame frame;
public MyDialog(MyFrame frame) {
    super(frame);
    this.frame = frame;
}
...
private void okButtonClicked() {
    String text = textField.getText();
    frame.userHasInputSomeText(text);
}