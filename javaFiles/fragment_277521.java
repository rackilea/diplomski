import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/** Sample 4 - how to trigger repeating actions from the main update loop.
 * In this example, we make the player character rotate. */
public class HelloLoop extends SimpleApplication {

    public static void main(String[] args){
        HelloLoop app = new HelloLoop();
        app.start();
    }

    protected Geometry player;

    @Override
    public void simpleInitApp() {

        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        player = new Geometry("blue cube", b);
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        player.setMaterial(mat);
        rootNode.attachChild(player);

        initKeys();
    }

    /* This is the update loop */
    @Override
    public void simpleUpdate(float tpf) {
        // make the player rotate
        player.rotate(0, val*tpf, 0); 
    }
    float val = 2f;
    private void initKeys() {
        // Adds the "u" key to the command "coordsUp"
        inputManager.addMapping("sum",  new KeyTrigger(KeyInput.KEY_ADD));
        inputManager.addMapping("rest",  new KeyTrigger(KeyInput.KEY_SUBTRACT));

        inputManager.addListener(al, new String[]{"sum", "rest"});
    }
      private ActionListener al = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
          if (name.equals("sum") ) {
              val++;
          }else if (name.equals("rest")){
              val--;
          }
        }
      };
}