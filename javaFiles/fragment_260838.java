public void update() 
{
     Gdx.input.setInputProcessor(new InputProcessor() {
        @Override
        public boolean TouchDown(int x, int y, int pointer, int button) {
            if (button == Input.Buttons.LEFT) {
                rotateRight();
                return true;
            }
            return false
        }
    });
}