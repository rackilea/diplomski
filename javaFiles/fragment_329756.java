InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
 ActionMap am = getActionMap();

 im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
 am.put("space", new AbstractAction() {
     public void actionPerformed(ActionEvent evt) {
         if (timer.isRunning()) {
             timer.stop();
         } else {
             timer.start();
         }
     }
 });