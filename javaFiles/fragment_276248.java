Runnable task = new Runnable() {
   public void run() {
      // do your download

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            // call some method to tell the GUI that the download finished.
         }
      });
   }
};