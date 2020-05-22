protected void fireActionPerformed(ActionEvent e)
 {
     // Dispatch a copy of the given ActionEvent in order to
     // set the source and action command correctly.
     ActionEvent ae = new ActionEvent(
         this,
         e.getID(),
         getActionCommand(),
         e.getWhen(),
         e.getModifiers());

     ActionListener[] listeners = getActionListeners();

     for (int i = 0; i < listeners.length; i++) //no way to prematurely terminate this loop 
       listeners[i].actionPerformed(ae);
 }