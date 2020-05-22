Runnable doHelloWorld = new Runnable() {
     public void run() {
         Window w = new Window(new DatabaseManager());
         w.pack();
         w.setVisible(true);
     }
 };

 SwingUtilities.invokeLater(doHelloWorld);