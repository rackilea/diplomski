public void enableCheckboxes(){
    Component [] c = gui.panel.getComponents();
    for (Component c1 : c) {
      if (c1 instanceof JCheckBox) {
        c1.setEnabled(true);
      }
    }
  }