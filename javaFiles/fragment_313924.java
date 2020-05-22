public class SetUpWorldWindowGLCanvas {

    WorldWindowGLCanvas worldWindCanvas = new WorldWindowGLCanvas();

    public SetUpWorldWindowGLCanvas() {
        worldWindCanvas.setModel(new BasicModel());
        Position myPoint = Position.fromDegrees(31.12, -88.64, 35000);

        // ... etc
    }

    public WorldWindowGLCanvas getWwGlCanvas() {
        return worldWindCanvas;
    }
}