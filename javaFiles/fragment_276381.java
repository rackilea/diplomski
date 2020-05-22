//Add an internal frame listener so we can see
//what internal frame events it generates.
listenedToWindow.addInternalFrameListener(this);

listenedToWindow.addPropertyChangeListener(evt -> {
  String prop = evt.getPropertyName();
  JInternalFrame f = (JInternalFrame) evt.getSource();
  Object newValue = evt.getNewValue();
  if (JInternalFrame.IS_MAXIMUM_PROPERTY == prop) {
    String prefix;
    if (newValue == Boolean.TRUE) {
      prefix = "Internal frame maximized : ";
    } else {
      prefix = "Internal frame minimized : ";
    }
    String s = prefix + f;
    display.append(s + newline);
    display.setCaretPosition(display.getDocument().getLength());
  }
});
//...