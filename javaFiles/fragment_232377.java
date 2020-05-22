startListening(); // key listener

JFrame frame = new JFrame();
...
SwingUtilities.invokeLater(new Runnable() {

   @Override
      public void run() {
         frame.setVisible(true);
      }
});