r.addPropertyChangeListener(BindingNames.SERVICE_ADDED, new PropertyChangeListener() {
  public void propertyChange(final PropertyChangeEvent evt) {   
    Display.getDefault().asyncExec(new Runnable() {
      public void run() {
         // remove grpYourStatus from parent
         grpYourStatus.dispose();

         // add grpYourStatus (with updated values) to parent
         createStatusGroupBox();

         // refresh view
         parent.pack();
         parent.layout(true);
      }
    });
  }
});