import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class MyGdxGame implements ApplicationListener {

    private OrthographicCamera  camera;
    private SpriteBatch         batch;
    private Pixmap              _pixmap;
    private Texture             _pixmapTexture;
    private int                 _x  = 0;
    private int                 _y  = 0;
    private float               _w;
    private float               _h;
    private int                 _width;
    private int                 _height;

    @Override
    public void create() {
        _w = Gdx.graphics.getWidth();
        _h = Gdx.graphics.getHeight();
        _width = MathUtils.round(_w);
        _height = MathUtils.round(_h);

        camera = new OrthographicCamera(1f, _h / _w);
        camera.setToOrtho(false);
        batch = new SpriteBatch();

        _pixmap = new Pixmap(_width, _height, Format.RGBA8888);
        _pixmap.setColor(Color.RED);
        _pixmap.fillRectangle(0, 0, _width, _height);
        _pixmapTexture = new Texture(_pixmap, Format.RGB888, false);
    }

    @Override
    public void dispose() {
        batch.dispose();
        _pixmap.dispose();
        _pixmapTexture.dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void render() {
        updatePixMap();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(_pixmapTexture, 1f / 2f, _h / _w / 2f);
        batch.end();
    }

    @Override
    public void resize(final int width, final int height) {
    }

    @Override
    public void resume() {
    }

    private void updatePixMap() {
        _x += 1;
        if (_x >= _width) _x = 0;

        _y += 1;
        if (_y >= _height / 2) return;

        _pixmap.setColor(Color.CYAN);
        _pixmap.drawPixel(_x, _y);
        _pixmapTexture = new Texture(_pixmap, Format.RGB888, false);
    }
}