addListener(new InputListener(){
        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            System.out.println("Touch");
            super.touchUp(event, x, y, pointer, button);
        }

        // Add this:
        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            System.out.println("down");
            return true;  // Important!
        }
    });