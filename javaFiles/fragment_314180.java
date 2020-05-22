import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClickTest implements ApplicationListener {
    private Stage stage;
    private Skin skin;

    @Override public void create() {
        Gdx.app.log("CREATE", "App Opening");

        this.skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        String sentence = "One two three four five six seven eight";
        String[] temp = sentence.split(" ");
        List<String> words = new ArrayList<String>(Arrays.asList(temp));

        final Label info = new Label("Welcome to Android!", skin);

        for (int i = 0; i < words.size(); i++) {
            // make i final here so you can reference it inside
            // the anonymous class
            final int index = i; 

            TextButton button = new TextButton(words.get(i), skin);
            table.add(button);

            button.addListener(new ClickListener() {
                @Override public void clicked(InputEvent event, float x, float y) {
                    // When you click the button it will print this value you assign.
                    // That way you will know 'which' button was clicked and can perform
                    // the correct action based on it.
                    Gdx.app.log("button", "clicked " + index);  

                    info.setText(Integer.toString(index));
                };
            });
        }

        table.row();
        // Changed this so it actually centers the label.
        table.add(info).colspan(words.size()).expandX(); 

        Gdx.input.setInputProcessor(stage);

        Gdx.gl20.glClearColor(0f, 0f, 0f, 1);
    }

    @Override public void render() {
        this.stage.act();
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glEnable(GL20.GL_BLEND);
        this.stage.draw();
    }

    @Override public void dispose() {
        Gdx.app.log("DISPOSE", "App Closing");
    }

    @Override public void resize(final int width, final int height) {
        Gdx.app.log("RESIZE", width + "x" + height);
        Gdx.gl20.glViewport(0, 0, width, height);
        this.stage.setViewport(width, height, false);
    }

    @Override public void pause() { }

    @Override public void resume() { }
}