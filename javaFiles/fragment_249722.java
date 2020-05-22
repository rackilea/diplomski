tabbedPane.addChangeListener(e -> {
  Component comp = tabbedPane.getSelectedComponent();
  if (comp.equals(pnlFoo)) {
    txtFoo.requestFocusInWindow();
  } else if (comp.equals(pnlBar)) {
    txtBar.requestFocusInWindow();
  }
});