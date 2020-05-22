Timer timer = new Timer(0, new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent e) {
    updateDialogSize();
   }
});

timer.setDelay(5); // short delay
timer.start();