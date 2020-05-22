label2.addPropertyChangeListener(new PropertyChangeListener() {
   public void propertyChange(PropertyChangeEvent evt) {
    if (!evt.getPropertyName().equals("enabled"))
     return;
    if (evt.getNewValue().equals(Boolean.FALSE))
     label2.setText("<html><font color=gray>HTML <b>text</b></html>");
    else
     label2.setText("<html><font color=black>HTML <b>text</b></html>");
   }
  });