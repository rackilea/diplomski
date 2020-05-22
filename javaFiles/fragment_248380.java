import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class FightTest extends SimpleApplication {

    Geometry box1;
    Geometry box2;
    public static void main(String[] args) {
        FightTest app = new FightTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {

        //put in some reference boxes
        for(int i=-20;i<=20;i+=20){
            for(int j=-20;j<=20;j+=20){
                if (j!=0||i!=0){
                    Geometry referenceBox = createBox(ColorRGBA.Red);
                    referenceBox.setLocalTranslation(i, 0, j);
                    rootNode.attachChild(referenceBox);
                }

            }
        }

        //put in our two players
        box1 = createBox(ColorRGBA.Blue);
        box1.setLocalTranslation(5, 0, 0);

        box2 = createBox(ColorRGBA.Green);

        rootNode.attachChild(box1);
        rootNode.attachChild(box2);
    }

    private Geometry createBox(ColorRGBA color){

        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        Geometry box = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        box.setMaterial(mat);

        return box;
    }

    @Override
    public void simpleUpdate(float tpf) {
        adjustCam();
        movePlayers(tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    private void adjustCam(){
        //we want our camera to look at the centre of the boxes
        Vector3f boxsCentre=box1.getWorldTranslation().add(box2.getWorldTranslation()).mult(0.5f);

        cam.lookAt(boxsCentre, Vector3f.UNIT_Y);

        //we also want our camera to move closer/further away as the boxes seperate.
        //and move around so its always parallel to the action

        //parallel to the action means on the line given by the cross product of the
        //box seperation and the upwards vector

        Vector3f seperationVector=box2.getWorldTranslation().subtract(box1.getWorldTranslation());
        Vector3f perpendicularFromTheAction= seperationVector.cross(Vector3f.UNIT_Y);

        perpendicularFromTheAction.normalizeLocal();

        //we could (and you should) get complicated on exactly how far the camera should 
        //move backwards, but I'm just going to make the camera twice as far away as the 
        //objects are seperated 
        float distance=2*seperationVector.length();

        Vector3f newCameraLocation=boxsCentre.add(perpendicularFromTheAction.mult(distance));

        cam.setLocation(newCameraLocation);
    }

    float timeAccumulator=0; 
    private void movePlayers(float tpf){
        //basic movement, just for demo
        timeAccumulator+=tpf;

        if (timeAccumulator<2){
            box1.move(new Vector3f(5f*tpf,0,0));
            box2.move(new Vector3f(0,0,5f*tpf));
        }else if (timeAccumulator<4){
            box1.move(new Vector3f(-5f*tpf,0,0));
            box2.move(new Vector3f(0,0,-5f*tpf));
        }else{
             timeAccumulator=0;
        }

    }
}