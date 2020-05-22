import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import android.os.Bundle;
import android.view.Menu;

public class TestBed extends SimpleBaseGameActivity {

    // ===========================================================
    // Constants
    // ===========================================================

    private static final int CAMERA_WIDTH = 720;
    private static final int CAMERA_HEIGHT = 480;

    // ===========================================================
    // Fields
    // ===========================================================

    private ITexture mTexture;
    private ITextureRegion mFaceTextureRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test_bed);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test_bed, menu);
        return true;
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

        return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
    }

    @Override
    public void onCreateResources() {
        try {
            this.mTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
                @Override
                public InputStream open() throws IOException {
                    return getAssets().open("tank.png");
                }
            });

            this.mTexture.load();
            this.mFaceTextureRegion = TextureRegionFactory.extractFromTexture(this.mTexture);
        } catch (IOException e) {
            Debug.e(e);
        }
    }
    ArrayList<Sprite> placedSprites = new ArrayList<Sprite>();
    @Override
    protected Scene onCreateScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());

        final Scene scene = new Scene();
        scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));

        /* Calculate the coordinates for the face, so its centered on the camera. */
        final float centerX = (CAMERA_WIDTH - this.mFaceTextureRegion.getWidth()) / 2;
        final float centerY = (CAMERA_HEIGHT - this.mFaceTextureRegion.getHeight()) / 2;

        /* Create the face and add it to the scene. */
        for (int i = 0; i < 20; i++) {
            final Sprite face = new Sprite(centerX, centerY, this.mFaceTextureRegion, this.getVertexBufferObjectManager());
            scene.attachChild(face);
            face.setPosition((float)(Math.random()*CAMERA_WIDTH), (float)(Math.random()*CAMERA_HEIGHT));
            while(faceDoesNotOverlap(face)){
                face.setPosition((float)(Math.random()*CAMERA_WIDTH), (float)(Math.random()*CAMERA_HEIGHT));                
            }
            placedSprites.add(face);

        }

        return scene;
    }

    private boolean faceDoesNotOverlap(Sprite face) {
        for (int i = 0; i < placedSprites.size(); i++) {
            if(face.collidesWith(placedSprites.get(i))){
                return true;
            }
        }
        return false;
    }



}