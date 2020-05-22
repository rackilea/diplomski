import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Create {

    private Skin menuSkin = Assets.menuSkin;
    private Stage pauseStage = new Stage(), skillStage = new Stage();
    private Table pauseTable = new Table(), skillTable = new Table();

    private TextButton pauseContinue = new TextButton("Continue", menuSkin),
            pauseExit = new TextButton("Exit", menuSkin),
            pauseSkill = new TextButton("Skills", menuSkin),
            buttonStrength = new TextButton("Strength", menuSkin),
            buttonCrit = new TextButton("Crit", menuSkin),
            buttonExp = new TextButton("Exp", menuSkin),
            buttonBack = new TextButton("Back", menuSkin);

    private Label pauseLabel = new Label("Pause", menuSkin);
    private GameScreen gameScreen = new GameScreen(this);

    public void screenGame() {
        pauseContinue.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.gl.glClearColor(0, 0, 0, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                gameScreen.runGame(); 
            }
        });
        pauseExit.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        pauseSkill.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.gl.glClearColor(0, 0, 0, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                gameScreen.skillGame();
            }
        });

        pauseTable.add(pauseLabel).padBottom(40).row();
        pauseTable.add(pauseContinue).size(150, 60).padBottom(20).row();
        pauseTable.add(pauseExit).size(150, 60).padBottom(20).row();
        pauseTable.add(pauseSkill).size(150, 60).padBottom(20).row();
        pauseTable.add(gameScreen.stats).width(250).padBottom(10).row();
        pauseTable.setFillParent(true);
        pauseStage.addActor(pauseTable);

    }

    public void screenPause() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pauseStage.act();
        pauseStage.draw();
    }

    public void screenSkill() {
        skillTable.add(pauseLabel).padBottom(40).row();
        skillTable.add(buttonStrength).size(150, 60).padBottom(20).row();
        skillTable.add(buttonCrit).size(150, 60).padBottom(20).row();
        skillTable.add(buttonExp).size(150, 60).padBottom(20).row();
        skillTable.add(buttonBack).size(150, 60).padBottom(20).row();
        skillTable.setFillParent(true);
        skillStage.addActor(skillTable);
    }
}