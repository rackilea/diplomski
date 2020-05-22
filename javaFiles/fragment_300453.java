@Override
public void resize(int width, int height) {
    float aspectRatio = (float) width / (float) height;
    camera = new PerspectiveCamera(64, cameraViewHeight * aspectRatio, cameraViewHeight);
    viewMatrix = new Matrix4();
    viewMatrix.setToOrtho2D(0, 0,width, height);
    spriteBatch.setProjectionMatrix(viewMatrix);
}