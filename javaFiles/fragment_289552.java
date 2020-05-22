public void actionPerformed(ActionEvent e) {
   List listeners = mActionListeners; // Edit 20090903
   for (Iterator iterator = listeners .iterator(); iterator.hasNext();) {
    ActionListener actionListener = (ActionListener)iterator.next();
    actionListener.actionPerformed(e);
   }
}