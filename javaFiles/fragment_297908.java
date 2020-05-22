public class ScreenInputHandler implements InputProcessor {

    private final Game game;

    public ScreenInputHandler(Game game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.BACK || keycode == Keys.BACKSPACE){       
            if (game.getScreen() instanceof MainMenuScreen) {
                Gdx.app.exit();
            }
            if (game.getScreen() instanceof GameScreen) {
                World.getInstance().togglePause(false);
            }
            if (game.getScreen() instanceof CreditsScreen) {
                game.setScreen(new MainMenuScreen(game));
            }
        }
        return false;
    }

}