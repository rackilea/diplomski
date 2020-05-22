public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.setShowSettings(false);
        app.start(); // start the game
    }

    final float speed = 0.01f;

    BitmapText hudText;
    Quaternion orientation;
    DirectionalLight sun;

    @Override
    public void simpleInitApp() {

        flyCam.setEnabled(false);
        setDisplayStatView(false); 
        setDisplayFps(false);


        hudText = new BitmapText(guiFont, false);          
        hudText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
        hudText.setColor(ColorRGBA.Blue);                             // font color
        hudText.setText("");             // the text
        hudText.setLocalTranslation(300, hudText.getLineHeight()*2, 0); // position
        guiNode.attachChild(hudText);

        cam.setLocation(new Vector3f(10, 0, 0));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Z);

        addOriginalSphere();
        addRotatedSphere();

    }

    public void addOriginalSphere(){
        Sphere sphere1Mesh = new Sphere(50, 50, 2);
        sphere1Mesh.setTextureMode(Sphere.TextureMode.Projected); // matrc

        Material sphere1Mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        sphere1Mat.setTexture("ColorMap", assetManager.loadTexture("Textures/world.png"));

        Geometry sphere1Geo = new Geometry("Original Sphere", sphere1Mesh);
        sphere1Geo.setMaterial(sphere1Mat); 
        sphere1Geo.setLocalTranslation(0, -2, 0);

        rootNode.attachChild(sphere1Geo);
    }
    public void addRotatedSphere(){
        Sphere sphere1Mesh = new Sphere(50, 50, 2);
        sphere1Mesh.setTextureMode(Sphere.TextureMode.Projected); // matrc

        Material sphere1Mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        sphere1Mat.setTexture("ColorMap", assetManager.loadTexture("Textures/world.png"));

        Geometry sphere1Geo = new Geometry("Rotated Sphere", sphere1Mesh);
        sphere1Geo.setMaterial(sphere1Mat); 
        sphere1Geo.setLocalTranslation(0, 2, 0);

        //Add this
        Quaternion quat=new Quaternion();
        quat.fromAngles(0 ,0 , FastMath.PI);
        sphere1Geo.setLocalRotation(quat);

        rootNode.attachChild(sphere1Geo);
    }

    @Override
    public void simpleUpdate(float tpf) {



    }

}