public void run() {
    while(true) {
          gameUpdate(); 
          if(getGraphics() != null){
              gameRender();   // render the game to a buffer
              try {
                  SwingUtilities.invokeAndWait(new Runnable() {
                      public void run() {
                          paintScreen();  // draw the buffer on-screen
                      }
                  });
              } catch (Exception exp) {
                  exp.printStackTrace(); // please clean this up
              }
          }
          try {
            Thread.sleep(28);
          } catch (InterruptedException e) {}
    }
}