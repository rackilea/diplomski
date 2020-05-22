import java.awt.GraphicsConfiguration;

import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Node;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class SphereOrbit
{
    public static void main(String[] args) 
    {
        System.setProperty("sun.awt.noerasebackground", "true");
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

        GraphicsConfiguration config = 
            SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        frame.getContentPane().add(canvas);
        SimpleUniverse simpleUniverse = new SimpleUniverse(canvas);

        BranchGroup rootBranchGroup = new BranchGroup();
        createContents(rootBranchGroup);

        simpleUniverse.addBranchGraph(rootBranchGroup);
        Transform3D viewPlatformTransform = new Transform3D();
        Transform3D t0 = new Transform3D();
        t0.setTranslation(new Vector3d(0,0,10));
        Transform3D t1 = new Transform3D();
        t1.rotX(Math.toRadians(-30));
        viewPlatformTransform.mul(t1, t0);
        simpleUniverse.getViewingPlatform().
            getViewPlatformTransform().setTransform(viewPlatformTransform);;

        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static BoundingSphere boundingSphere = 
        new BoundingSphere(new Point3d(0.0,0.0,0.0), Double.MAX_VALUE);


    // Build the transform group that does the rotation
    // of the planet in its local coordinate system 
    // (This will cause the planet to spin about its own y-axis)
    private static TransformGroup createRotationTransformGroup(
        int rotationTimeMs)
    {
        TransformGroup rotationTransformGroup = new TransformGroup();
        rotationTransformGroup.setCapability(
            TransformGroup.ALLOW_TRANSFORM_WRITE);
        Alpha rotationAlpha = new Alpha(-1, rotationTimeMs);
        RotationInterpolator rotationInterpolator = 
            new RotationInterpolator(rotationAlpha, rotationTransformGroup);
        rotationInterpolator.setSchedulingBounds(boundingSphere);
        rotationTransformGroup.addChild(rotationInterpolator);
        return rotationTransformGroup;
    }

    // Build the transform group that moves the (rotating) planet 
    // about a certain (fixed) distance, away from the center
    private static TransformGroup createTranslatingTransformGroup(
        double distanceFromCenter)
    {
        TransformGroup translationTransformGroup = new TransformGroup();
        Transform3D translationTransform = new Transform3D();
        translationTransform.setTranslation(
            new Vector3d(distanceFromCenter, 0, 0));
        translationTransformGroup.setTransform(translationTransform);
        return translationTransformGroup;
    }

    // Build the transform group that orbits the planet. This
    // transform group will rotate the (translated and rotating)
    // planet around the center
    private static TransformGroup createOrbitTransformGroup(int orbitTimeMs)
    {
        TransformGroup orbitTransformGroup = new TransformGroup();
        orbitTransformGroup.setCapability(
            TransformGroup.ALLOW_TRANSFORM_WRITE);
        Alpha orbitAlpha = new Alpha(-1, orbitTimeMs);
        RotationInterpolator orbitInterpolator = 
            new RotationInterpolator(orbitAlpha, orbitTransformGroup);
        orbitInterpolator.setSchedulingBounds(boundingSphere);
        orbitTransformGroup.addChild(orbitInterpolator);
        return orbitTransformGroup;
    }


    private static void createContents(BranchGroup rootBranchGroup)
    {
        // The basic properties of the Planet
        int rotationTimeMs = 1500;
        double distanceFromCenter = 3;
        int orbitTimeMs = 4000;

        // The planet (using a color cube here, so that its 
        // own rotation is visible)
        //Node planet = new Sphere(0.2f);
        Node planet = new ColorCube(0.2);

        TransformGroup rotationTransformGroup = 
            createRotationTransformGroup(rotationTimeMs);

        // Attach the planet to the rotation transform group
        rotationTransformGroup.addChild(planet);

        TransformGroup translationTransformGroup =
            createTranslatingTransformGroup(distanceFromCenter);

        // Attach the rotating planet to the translation transform group
        translationTransformGroup.addChild(rotationTransformGroup);

        TransformGroup orbitTransformGroup = 
            createOrbitTransformGroup(orbitTimeMs);

        // Add the (translated and rotating) planet to the orbitTransformGroup
        orbitTransformGroup.addChild(translationTransformGroup);

        rootBranchGroup.addChild(orbitTransformGroup);
    }
}