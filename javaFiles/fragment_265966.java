public ContainerW(final int iD) {

    super();
    cRef = iD;
    this.emptyBreadth = 0;
    this.length = 0.8;
    this.height = 0.6;
    this.breadth = 0.5 - emptyBreadth;
    this.usedVolume = 0;
    volume = length * breadth * height;
    this.packedItems = new ArrayList<ItemsUnit>();


    //----------------------INTERFACE----------------------------

        this.setLayout(new BorderLayout());

        //create a canvas3D
        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        this.add(canvas3D, BorderLayout.CENTER);

        //create a universe
        simpleU = new SimpleUniverse(canvas3D);
        simpleU.getViewingPlatform().setNominalViewingTransform();

        //create a branch group scene 
        scene1 = new BranchGroup();


       //create an appearance for the container
        Appearance app = new Appearance();
        //Create the polygon attributes
        PolygonAttributes polyAttr = new PolygonAttributes();
        //Set them so that the draw mode is polygon line
        polyAttr.setPolygonMode(PolygonAttributes.POLYGON_LINE);
        polyAttr.setCullFace(PolygonAttributes.CULL_NONE);
        //Use these in the appearance
        app.setPolygonAttributes(polyAttr);

        //rotate the view angle 
        Transform3D rotateCube = new Transform3D();
        rotateCube.set(new AxisAngle4d(1.0, 1.0, 0.0, Math.PI /4.0));

        //create a transform Group for the container
        TransformGroup tg1 = new TransformGroup(rotateCube);
        tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        //create a box: container
        Box container = new Box ( (float) length , (float) breadth, (float)height, app);

        //add the container to the first transform group
        tg1.addChild(container);

        //add the first transform group to the branch group
        scene1.addChild(tg1);

        scene1.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);

        scene1.compile();

        simpleU.addBranchGraph(scene1);


       Frame frame = new MainFrame(this,800, 800); 


}