import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Move implements ApplicationListener {
    private static final Map<Integer, Direction> MOVE_KEYS = new HashMap<Integer, Direction>(){{
        this.put(Keys.RIGHT, Direction.RIGHT);
        this.put(Keys.LEFT, Direction.LEFT);
        this.put(Keys.UP, Direction.UP);
        this.put(Keys.DOWN, Direction.DOWN);
    }};

    private static enum Direction {
        RIGHT, LEFT, UP, DOWN;
    }

    private static class Player {
        public float x;
        public float y;
        public float speed;
        public Queue<Direction> dirStack = new LinkedList<Direction>();

        public Player(float x, float y, float speed) {
            this.x = x;
            this.y = y;
            this.speed = speed;
        }

        public void update(float delta) {
            if (!dirStack.isEmpty()) {
                switch(dirStack.peek()) {
                case DOWN: 
                    y -= speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
                case UP:
                    y += speed;
                    break;
                }
            }
        }

        public void render(ShapeRenderer render) {
            render.begin(ShapeType.FilledRectangle);
            render.setColor(1, 0, 0, 1);
            render.filledRect(x, y, 20, 20);
            render.end();
        }
    }

    private static class MoveController extends InputAdapter {
        private final Player player;

        public MoveController(Player player) {
            this.player = player;
        }

        @Override public boolean keyDown(int keycode) {
            if (MOVE_KEYS.containsKey(keycode)) {
                final Direction dir = MOVE_KEYS.get(keycode);
                Gdx.app.log("D", dir.toString());
                return player.dirStack.add(dir);
            }
            return false;
        }

        @Override public boolean keyUp(int keycode) {
            if (MOVE_KEYS.containsKey(keycode)) {
                final Direction dir = MOVE_KEYS.get(keycode);
                Gdx.app.log("U", dir.toString());
                return player.dirStack.remove(dir);
            }
            return false;
        }
    }

    private Camera cam;
    private ShapeRenderer render;
    private Player player;

    @Override public void create() {
        Gdx.app.log("CREATE", "App Opening");

        this.player = new Player(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 5);
        Gdx.input.setInputProcessor(new MoveController(player));

        this.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.render = new ShapeRenderer();

        cam.apply(Gdx.gl10);

        Gdx.gl10.glClearColor(0f, 0f, 0f, 1);
    }

    @Override public void render() {
        Gdx.gl10.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(Gdx.graphics.getDeltaTime());
        player.render(render);
    }

    @Override public void dispose() {
        Gdx.app.log("DISPOSE", "App Closing");
    }

    @Override public void resize(final int width, final int height) {
        Gdx.app.log("RESIZE", width + "x" + height);
        Gdx.gl10.glViewport(0, 0, width, height);
    }

    @Override public void pause() {}

    @Override public void resume() {}
}