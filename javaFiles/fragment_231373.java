TextField textField
textField.setFocusTraversal(false);
textField.setTextFieldListener(new TextFieldListener() {
    @Override
    public void keyTyped(TextField textField, char key) {
        if ((key == '\r' || key == '\n')){
            textField.next(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT));
        }
    }
});