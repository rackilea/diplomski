Timer timer = new Timer(0, new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent e) {
      updateRecords();
   }
});

timer.setDelay(30000); // delay for 30 seconds
timer.start();