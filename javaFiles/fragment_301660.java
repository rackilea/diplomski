public class MovingCamera extends InputAdapter {

    OrthographicCamera camera;    // The camera to be moved
    float pivotX;                 // The pivot for the movement

    public MovingCamera() {
        camera = new OrthographicCamera(); // Initialize camera
    }

    // Create a pivot
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 unprojected = camera.unproject(new Vector3(screenX, screenY, 0)); // Convert from pixel to world coordinates
        pivotX = unprojected.x;                                                   // Save first finger touch on screen (Will serve as a pivot)
        return true;                                                              // Input has been processed
    }

    // Move the camera
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 unprojected = camera.unproject(new Vector3(screenX, screenY, 0)); // Convert from pixel to world coordinates
        camera.position.x += unprojected.x - pivotX;                              // Change camera position
        camera.update();                                                          // Apply changes
        return true;                                                              // Input has been processed
    }
}