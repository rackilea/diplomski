while (Keyboard.next()) {
        if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
            if(state == State.INTRO) {
                clearCanvas();
                state = State.GAME;
            }
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_BACK)) {
            if(state == State.GAME) {
                clearCanvas();
                state = State.INTRO;
            }
        }
    }