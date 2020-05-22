import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class TestGame extends ApplicationAdapter
{
    Dialog  endDialog;

    Skin    skin;
    Stage   stage;

    @Override
    public void create()
    {
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        endDialog = new Dialog("End Game", skin)
        {
            protected void result(Object object)
            {
                System.out.println("Option: " + object);
                Timer.schedule(new Task()
                {

                    @Override
                    public void run()
                    {
                        endDialog.show(stage);
                    }
                }, 1);
            };
        };

        endDialog.button("Option 1", 1L);
        endDialog.button("Option 2", 2L);

        Timer.schedule(new Task()
        {

            @Override
            public void run()
            {
                endDialog.show(stage);
            }
        }, 1);

    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

    }

    @Override
    public void dispose()
    {
        stage.dispose();
    }
}