class InterfaceImpl {
    Thread proHs;
    boolean btnResponse;
   public boolean biddingStep(int gt) {
       System.out.println("  ");
       System.out.println("I HAVE OR NOT PART");
       panelLicitace.setVisible(true);
       mam.setVisible(true);
       nemam.setVisible(true) ;
       // HERE a code i want
       //1. stop proHS thread
       synchronized(proHs)
       {
         proHs.wait();
        //2. loop program, wait for input from 2 buttons
        //3. return true or false
           return btnResponse;
     }
  }   

  // This method should be called from another thread
  public boolean btnClickListener()
  { 
    btnResponse=true or false
      synchronized(proHs)
       {
         proHs.notify();
       }

   }
}