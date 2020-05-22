public void init() {
   EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        display();
      }
   });
}