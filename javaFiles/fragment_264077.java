public class Controller extends InputAdapter {
    private Entity _controllee;

    public void setControllee(Entity toControl) {
        _controllee = toControl;
    }

    // Override whichever InputAdapter methods you need to control your moveable objects, e.g.:
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        _controllee.newSpeedX = touchpad.getKnobPercentX() * Speed;
        _controllee.newSpeedY = touchpad.getKnobPercentY() * Speed;
        return true;
    }
}