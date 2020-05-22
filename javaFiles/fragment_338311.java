public class BebopVideoView extends TextureView implements TextureView.SurfaceTextureListener {

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.surface = new Surface(surface);
        surfaceCreated = true;
    }

...

}