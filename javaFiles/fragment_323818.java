public DesktopLauncher() {

    this.setUndecorated(true);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setTitle("Evil Engine (v. Lambda)");

    Container container = this.getContentPane();
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.resizable = false;
    System.setProperty("org.lwjgl.opengl.Window.undecorated", "true"); 
    this.canvas = new LwjglCanvas(new Main(DesktopLauncher.inst),config);

    // this.canvas.getCanvas().setLocation(200, -200);

    // height of the task bar
    int taskBarSize = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration()).bottom;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    this.canvas.getCanvas().setSize(screenSize.width, screenSize.height - taskBarSize);

    container.add(this.canvas.getCanvas(), BorderLayout.CENTER);

    this.pack();

    this.setVisible(true);
}