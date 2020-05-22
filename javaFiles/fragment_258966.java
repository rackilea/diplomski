final Map<KeyCode, Boolean> keyboard = new HashMap<>();
keyboard.put(KeyCode.SPACE, false);

scene.setOnKeyPressed(
    new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            if (e.getCode() == KeyCode.SPACE) {  
                keyboard.put(e.getCode(), true);
                // You could alternately call pig.jumpBoost()
                // directly from this handler and not having to 
                // deal with the 'keyboard' map at all
                // as illustrated with by pig.releaseLock()
                // in the next handler
            }
        }
    });

scene.setOnKeyReleased(
    new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {     
            if (e.getCode() == KeyCode.SPACE) {              
                keyboard.put(e.getCode(), false);
                pig.releaseLock(); // IMPORTANT!!!
            }
        }
    });