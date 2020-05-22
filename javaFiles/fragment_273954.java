public boolean pan(float x, float y, float deltaX, float deltaY){
    float scaleX = viewport.getWorldWidth() / (float)viewport.getScreenWidth();
    float scaleY = viewport.getWorldHeight() / (float)viewport.getScreenHeight();
    camera.translate((int)(-deltaX * scaleX), (int)(deltaY * scaleY));
    camera.update();
    return false;
}