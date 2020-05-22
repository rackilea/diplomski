package rajawali.tutorials;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;

import rajawali.Camera;
import rajawali.Object3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.Material;
import rajawali.materials.textures.ATexture.TextureException;
import rajawali.materials.textures.Texture;
import rajawali.primitives.Sphere;
import rajawali.renderer.RajawaliRenderer;

public class RajawaliTutorialRenderer extends RajawaliRenderer {

    public DirectionalLight light;
    public Object3D sphere;
    public Context context;
    public Camera camera;

    public RajawaliTutorialRenderer(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
    }

    public void initScene() {
        light = new DirectionalLight(1f, 0.2f, -1.0f); // set the direction
        light.setColor(1.0f, 1.0f, 1.0f);
        light.setPower(2);

        try{
            Material material = new Material();
            material.addTexture(new Texture("earthColors", R.drawable.earthtruecolor_nasa_big));
            material.setColorInfluence(0);
            sphere = new Sphere(1, 24, 24);
            sphere.setMaterial(material);
            getCurrentScene().addLight(light);
            super.addChild(sphere);
        } catch (TextureException e){
            e.printStackTrace();
        }

        getCurrentCamera().setZ(4.2f);
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        super.onDrawFrame(glUnused);
        sphere.setRotY(sphere.getRotY() + 1);
    }
}