public boolean keyTyped (InputEvent event, char character) {
     [...]
     if ((character == TAB || character == ENTER_ANDROID) && focusTraversal)
         next(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT));
     [...]
}