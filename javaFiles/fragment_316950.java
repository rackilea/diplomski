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
import com.sun.j3d.utils.universe.SimpleUniverse;

public class SphereOrbitExtended
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


    // Build the transform group that does a rotation about the
    // y-axis, rotating once in the given time
    private static TransformGroup createRotationTransformGroup(
        int rotationTimeMs, boolean forward)
    {
        TransformGroup rotationTransformGroup = new TransformGroup();
        rotationTransformGroup.setCapability(
            TransformGroup.ALLOW_TRANSFORM_WRITE);
        Alpha rotationAlpha = new Alpha(-1, rotationTimeMs);
        float angle = forward ? (float) (2 * Math.PI) : (float)(-2 * Math.PI);
        RotationInterpolator rotationInterpolator = 
            new RotationInterpolator(rotationAlpha, rotationTransformGroup, 
                new Transform3D(), 0.0f, angle);
        rotationInterpolator.setSchedulingBounds(boundingSphere);
        rotationTransformGroup.addChild(rotationInterpolator);
        return rotationTransformGroup;
    }

    // Build the transform group that performs the specified translation
    private static TransformGroup createTranslatingTransformGroup(
        double dx, double dy, double dz)
    {
        TransformGroup translationTransformGroup = new TransformGroup();
        Transform3D translationTransform = new Transform3D();
        translationTransform.setTranslation(
            new Vector3d(dx, dy, dz));
        translationTransformGroup.setTransform(translationTransform);
        return translationTransformGroup;
    }


    private static void createContents(BranchGroup rootBranchGroup)
    {
        int orbitTimeMs = 4000;
        TransformGroup orbitTransformGroup = 
            createRotationTransformGroup(orbitTimeMs, true);
        rootBranchGroup.addChild(orbitTransformGroup);

        double distanceFromCenter = 3;
        TransformGroup translationTransformGroup =
            createTranslatingTransformGroup(distanceFromCenter, 0, 0);
        orbitTransformGroup.addChild(translationTransformGroup);

        int rotationTimeMs = 1500;
        Node planet = new ColorCube(0.2);
        TransformGroup rotationTransformGroup = 
            createRotationTransformGroup(rotationTimeMs, true);
        rotationTransformGroup.addChild(planet);
        translationTransformGroup.addChild(rotationTransformGroup);

        int moonOrbitTimeMs = 1000;
        TransformGroup moonOrbitTransformGroup = 
            createRotationTransformGroup(moonOrbitTimeMs, false);
        translationTransformGroup.addChild(moonOrbitTransformGroup);

        double moonDistanceFromPlanet = 0.8;
        TransformGroup moonTranslationTransformGroup =
            createTranslatingTransformGroup(moonDistanceFromPlanet, 0, 0);
        moonOrbitTransformGroup.addChild(moonTranslationTransformGroup);

        int moonRotationTimeMs = 500;
        Node moon = new ColorCube(0.1);
        TransformGroup moonRotationTransformGroup = 
            createRotationTransformGroup(moonRotationTimeMs, true);
        moonRotationTransformGroup.addChild(moon);
        moonTranslationTransformGroup.addChild(moonRotationTransformGroup);
    }


}