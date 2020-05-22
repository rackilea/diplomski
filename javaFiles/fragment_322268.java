JOptionPane pane = new JOptionPane(arguments);
 // Configure via set methods
 JDialog dialog = pane.createDialog(parentComponent, title);
 // the line below is added to the example from the docs
 dialog.setModal(false); // this says not to block background components
 dialog.show();
 Object selectedValue = pane.getValue();
 if(selectedValue == null)
   return CLOSED_OPTION;
 //If there is not an array of option buttons:
 if(options == null) {
   if(selectedValue instanceof Integer)
      return ((Integer)selectedValue).intValue();
   return CLOSED_OPTION;
 }
 //If there is an array of option buttons:
 for(int counter = 0, maxCounter = options.length;
    counter < maxCounter; counter++) {
    if(options[counter].equals(selectedValue))
    return counter;
 }
 return CLOSED_OPTION;