public void actionPerformed(ActionEvent event) {
   String command = event.getActionCommand();
   command = event.getActionCommand();
   Runnable printChoice = new Runnable() {
     @Override
     public void run() {
      try{
        Thread.sleep(500);
        if ("choice1".equals(command)){
            System.out.println("choice1");
        }
        else if("choice2".equals(command)){
            System.out.println("choice2");
        }
        else{
            System.out.println("no choice");
        }
      }   
      catch(InterruptedException ex){
        Thread.currentThread().interrupt();
      }
    });
    new Thread(printChoice).start();
}