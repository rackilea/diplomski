public abstract class Scene extends SurfaceView implements Runnable {

    Thread thread;
    Activity activity;

    public Scene(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void run() {
        activity.runOnUiThread(() -> {
            activity.setFps("Hello");
        });
    }

    public void resume() {
        thread = new Thread(this);
        thread.start();
    }