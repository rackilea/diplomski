FocusListener f = new FocusListener() {
  public void focusGained(FocusEvent e) {
      Component source = e.getComponent();
      if (source instanceof JTextField) {
          ((JTextField)source).setText("");
      }
  }