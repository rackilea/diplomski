Gdx.input.setInputProcessor(new InputProcessor() {
    public boolean touchDown(int x, int y, int point, int button) {
        if (button == Input.Buttons.LEFT) {
            new MyClass();
            return true;
        }
        return false;
    }
});