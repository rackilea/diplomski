public class UnityPlayerWrapper extends UnityPlayer {
    public UnityPlayerWrapper(ContextWrapper contextWrapper) {
        super(contextWrapper);
    }

    @Override
    protected void setFullscreen(boolean b) {
        super.setFullscreen(false);
    }
}