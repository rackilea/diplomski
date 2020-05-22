// in run(), was repaint():
EventQueue.invokeLater(new Runnable() {
   @Override
   public void run() {
       repaint();
   }
});