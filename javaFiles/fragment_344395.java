variables = update.updateGravity();  // runs in your main thread
SwingUtilities.invokeLater(new Runnable() {    
   @Override public void run() {
       yourCustomSwingComponent.update(variables);   // will run on the Swing EDT
   }
}