public ActionListener startServerListener = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    try {
      new Thread(new Runnable({
        public void run(){
          try{
            // Update GUI #1
            SwingUtilities.invokeAndWait(new Runnable(){
              public void run(){
                view.updateServerNotice(new String("Server is starting..."));
              }
            });

            //Start Server in new thread
            Thread t1 = new Thread(model);
            t1.start();
            Thread.sleep(1000);

            // Update GUI #2
            SwingUtilities.invokeAndWait(new Runnable(){
              public void run(){
                view.showNotification(model.hostAvailabilityCheck() + "");
              }
            });
          }catch(Exception ex){/*...*/}
        }
      })).start();
    }catch(Exception ex){/*...*/}
  }
};