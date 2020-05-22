private void showDialog(
    MyDialog dialog = new MyDialog(this);
    dialog.setVisible(true);
}

public void userHasInputSomeText(String text) {
    // do whatever you want with the text
    System.out.println("User has entered this text in the dialog: " + text);
}