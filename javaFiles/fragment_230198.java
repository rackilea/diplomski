import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class GameScreen implements Screen {

    private Create create;
    public GameScreen(Create create) {
        this.create = create;
    }

    private Texture[] monsterTextures = {
            Assets.manager.get(("Ressources/DemonHunter.jpg"), Texture.class),
            Assets.manager.get(("Ressources/WingedDemon.jpg"), Texture.class),
            Assets.manager.get(("Ressources/Viking.jpg"), Texture.class),
            Assets.manager.get(("Ressources/DemonWarrior.jpg"), Texture.class) };

    private Image[] monsterImages = { new Image(monsterTextures[0]),
            new Image(monsterTextures[1]), new Image(monsterTextures[2]),
            new Image(monsterTextures[3]) };

    private Stage gameStage = new Stage();
    private Table table = new Table();
    private Skin menuSkin = Assets.menuSkin;

    private int randomMonster;
    private int currentMonsterLife = 1 + (int) (Math.random() * ((10 - 1) + 1));
    private TextField hitpoints = new TextField("Hitpoints: "
            + currentMonsterLife, menuSkin);
    public int exp = 0, lvl = 1, skillpoints = 0;
    public TextField stats = new TextField("    " + "Level: " + lvl + ", Exp: "
            + exp + ", Skillpoints: " + skillpoints, menuSkin);
    public final int GAME_RUNNING = 1;
    public final int GAME_PAUSED = 2;
    public final int GAME_SKILLED = 3;
    private int gamestatus;

    @Override
    public void show() {
        randomMonster = 0 + (int) (Math.random() * ((3 - 0) + 1));
        gameStage.addActor(monsterImages[randomMonster]);
        Gdx.input.setInputProcessor(gameStage);

    }

    public void newMonster() {
        exp += 1;
        if (exp >= lvl * 5 * 2) {
            lvl += 1;
            skillpoints += 1;
        }
        monsterImages[randomMonster].remove();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        randomMonster = 0 + (int) (Math.random() * ((3 - 0) + 1));
        currentMonsterLife = 1 + (int) (Math.random() * ((5 - 1) + 1));
        hitpoints = new TextField("Hitpoints: " + currentMonsterLife, menuSkin);
        table.removeActor(stats);
        stats = new TextField("    " + "Level: " + lvl + ", Exp: " + exp
                + ", Skillpoints: " + skillpoints, menuSkin);
        table.add(stats).width(250).row();
        gameStage.addActor(monsterImages[randomMonster]);
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
            pauseGame();
        if (gamestatus == GAME_PAUSED)
            create.screenPause(); // Not working

        if (gamestatus == GAME_RUNNING) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            gameStage.addActor(hitpoints);
            gameStage.act();
            gameStage.draw();

            if (Gdx.input.justTouched()) {
                currentMonsterLife -= 1;
                hitpoints = new TextField("Hitpoints: " + currentMonsterLife,
                        menuSkin);
            }

            if (currentMonsterLife == 0) {
                newMonster();
            }
        }
    }

    public void pauseGame() {
        gamestatus = GAME_PAUSED;

    }

    public void runGame() {
        gamestatus = GAME_RUNNING;
    }

    public void skillGame() {
        gamestatus = GAME_SKILLED;

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        pauseGame();
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        for (int i = 0; i < monsterTextures.length; i++) {
            monsterTextures[i].dispose();
        }
        gameStage.dispose();
        // pauseStage.dispose();
        menuSkin.dispose();
    }
}