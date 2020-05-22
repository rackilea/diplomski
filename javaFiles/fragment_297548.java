final Set<String> pressedKeys = new HashSet<String>();

    keyboard.setOnKeyPressed(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent t) {
            String note = t.getText();
            if (!pressedKeys.contains(note)) {
                // you may need to introduce synchronization here
                pressedKeys.add(note);

                playNote(note);
            }
        }
    });
    keyboard.setOnKeyReleased(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent t) {
            pressedKeys.remove(t.getText());
        }
    });