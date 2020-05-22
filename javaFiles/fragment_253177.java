JTextArea area =...;

SwingUtilities.invokeLater(new Runnable() {
   public void run() {
      area.requestFocus();
   }
});