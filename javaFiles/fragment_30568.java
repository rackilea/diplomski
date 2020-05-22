public class MyGestureDetector extends GestureDetector {
    private Stage stage;
    public MyGestureDetector(GestureListener listener,Stage stage) {
        super(listener);
        this.stage = stage;
    }


    @Override
    public boolean keyDown(int keycode) {
        stage.keyDown(keycode);
        super.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        stage.keyUp(keycode);
        super.keyUp(keycode);
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        stage.keyTyped(character);
        super.keyTyped(character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        stage.touchDown(screenX, screenY, pointer, button);
        super.touchDown(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        stage.touchUp(screenX, screenY, pointer, button);
        super.touchUp(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        stage.touchDragged(screenX, screenY, pointer);
        super.touchDragged(screenX, screenY, pointer);

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        stage.mouseMoved(screenX, screenY);
        super.mouseMoved(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        stage.scrolled(amount);
        super.scrolled(amount);
        // TODO Auto-generated method stub
        return false;
    }


}