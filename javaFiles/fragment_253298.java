SwingUtilities.invokeLater(new Runnable() {
   public void run() {
     gui = new Gui();
     gui.launch();
     animThread = new AnimationThread();

   }
});