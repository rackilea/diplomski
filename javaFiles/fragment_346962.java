GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3d = new Canvas3D(config);

    // Manually create the viewing platform so that we can customize it
    ViewingPlatform viewingPlatform = new ViewingPlatform();

    // **** This is the part I was missing: Activation radius
    viewingPlatform.getViewPlatform().setActivationRadius(300f);

    // Set the view position back far enough so that we can see things
    TransformGroup viewTransform = viewingPlatform.getViewPlatformTransform();
    Transform3D t3d = new Transform3D();
    // Note: Now the large value works
    t3d.lookAt(new Point3d(0,0,150), new Point3d(0,0,0), new Vector3d(0,1,0));
    t3d.invert();
    viewTransform.setTransform(t3d);

    // Set back clip distance so things don't disappear 
    Viewer viewer = new Viewer(canvas3d);
    View view = viewer.getView();
    view.setBackClipDistance(300);

    SimpleUniverse universe = new SimpleUniverse(viewingPlatform, viewer);