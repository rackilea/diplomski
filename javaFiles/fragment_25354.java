@Override
public void resize(int width, int height) {
    camera.viewportWidth = width;
    camera.viewportHeight = height;
    camera.position.set(width/2f, height/2f, 0); //by default camera position on (0,0,0)
}