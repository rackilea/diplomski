public Listener() {
    GLProfile glp = GLProfile.getDefault();
    GLCapabilities caps = new GLCapabilities(glp);
    GLCanvas canvas = new GLCanvas(caps);  
    setSize(300, 300);
    add(canvas);
    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    canvas.addGLEventListener(this);     
    canvas.addKeyListener(this);

    FPSAnimator animator = new FPSAnimator(canvas, 60);
    animator.start();
}