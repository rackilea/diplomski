if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
    clearCanvas(); //Don't check for the state which is going to be true most likely, just adds confusion to coding
    state = State.GAME;
}

if (Keyboard.isKeyDown(Keyboard.KEY_BACK)){
    clearCanvas();
    state = State.INTRO;
}