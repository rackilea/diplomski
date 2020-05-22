public void resize (int width, int height){
    if (frameBuffer != null) frameBuffer.dispose();
    try {
        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, width/2, height/2, false); 
    } catch (GdxRuntimeException e) {
        frameBuffer = new FrameBuffer(Pixmap.Format.RGB565, width/2, height/2, false);
    }
}