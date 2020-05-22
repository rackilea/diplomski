public class OptionsScreen implements Screen, InputProcessor {
    final MyGame game;
    public OptionsScreen(MyGame game) { this.game = game; }
    ...
    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.BACK) {
            game.setScreen(game.mainScreen);
            return true;
        }
        return false;
    }
    ...
}