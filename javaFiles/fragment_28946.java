// ***********declare these variables in class where canvas3D lives *****
//J3D stuff
public InteractiveCanvas3D  canvas3D;
public SimpleUniverse       simpleUniv;
private Transform3D         viewingTransform;
private TransformGroup viewingTransformGroup;

public  static Point3d viewersLocation;
public  static Point3d gazePoint;  //point viewer is looking at

// and initialize as follows:

viewingTransformGroup = simpleUniv.getViewingPlatform().getViewPlatformTransform();
viewingTransform = new Transform3D();


//called to update viewer's location and gaze:
// *********************** UpdateViewerGeometryJ3D 
public void UpdateViewerGeometryJ3D()  {
    Point3d eye = viewersLocation;  
    Point3d center = gazePoint;
    Vector3d up = upDir;
    viewingTransform.lookAt(eye, center, up);
    viewingTransform.invert();
    viewingTransformGroup.setTransform(viewingTransform);