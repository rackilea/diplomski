private boolean wasDragged = false;

public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
    octave3Btn.getColor().a = 0.25f;
    wasDragged = false;
    return true;
}

public boolean touchDragged(InputEvent event, float x, float y, int pointer) {
    // you can use a simple flag here, or better calculate the distance
    // and set the flag when the distance surpassed a certain limit
    wasDragged = true;
}

public boolean touchUp(InputEvent event, float x, float y, int pointer, int button) {
    octave3Btn.getColor().a = 1f;
    if (!wasDragged) {
        launcher.setScreen(new ListNotesScreen(...));
    }
}