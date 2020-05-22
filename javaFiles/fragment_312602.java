private final String title;

public CustomFileChooser(String title) {
  this.title = title;
  setApproveButtonText(title);
  this.button = getOpenButton(this);
}

private JButton getOpenButton(Container c) {
  Validator.checkNull(c);

  int len = c.getComponentCount();
  JButton button = null;
  for (int index = 0; index < len; index++) {
    if (button != null) {
      break;
    }
    Component comp = c.getComponent(index);
    if (comp instanceof JButton) {
      JButton b = (JButton) comp;

      if (this.title.equals(b.getText())) {
        return b;
      }
    }
    else if (comp instanceof Container) {
      button = getOpenButton((Container) comp);
    }
  }
  return button;
}