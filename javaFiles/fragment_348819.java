// Global static field in your game class
public static int VIRTUAL_WIDTH = XXX;
public static int VIRTUAL_HEIGHT = XXX;

// ...

camera = new OrthographicCamera();
viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
viewport.apply();