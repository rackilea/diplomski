import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

/**
 * Created by Crowni on 10/6/2015.
 */
public class NavigationDrawer {
    // this value is suitable
    private static final float INTERVAL_SEC = 0.001f;

    // Some attributes for {@link NavigationDrawer}
    private static float CAM_MAIN_POSITION;
    public static float WIDTH;
    public static float SPEED;

    private static OrthographicCamera camera;

    /**
     * To ensure the {@link NavigationDrawerListener#onFinish()} called one time
     **/
    private static boolean isFinish = true;

    private static Task task;
    private static Timer timer = new Timer();

    private static NavigationDrawerListener listener;

    public interface NavigationDrawerListener {
        public void onStart();

        // May be you want to make some Actions here during sliding
        public void onRun();

        public void onFinish(float camX);
    }

    public static void initialize(Stage stage, NavigationDrawerListener listener) {
        NavigationDrawer.listener = listener;
        camera = ((OrthographicCamera) stage.getCamera());
        setNavigationDrawerDefault(stage);
        initializeTimerTask(false);
    }

    private static void setNavigationDrawerDefault(Stage stage) {
        WIDTH = stage.getWidth() - stage.getWidth() / 3;
        CAM_MAIN_POSITION = stage.getWidth() / 2;
        SPEED = 2f;
    }

    private static Task initializeTimerTask(boolean show) {
        task = new Task() {
            public void run() {
                if (!timer.isEmpty()) {
                    if (show)
                        camera.position.x -= SPEED;
                    else
                        camera.position.x += SPEED;

                    listener.onRun();
                } else if (isFinish) {
                    listener.onFinish(setDefaultCameraEndPostion(show));
                }
            }
        };
        return task;
    }

    /**
     * @param show
     *            : I passed it here because I know it is correct choice
     **/
    private static float setDefaultCameraEndPostion(boolean show) {
        isFinish = false;
        if (show)
            return camera.position.x = CAM_MAIN_POSITION - WIDTH;
        else
            return camera.position.x = CAM_MAIN_POSITION;
    }

    private static boolean isOpened() {
        return camera.position.x != CAM_MAIN_POSITION;
    }

    public static void show(boolean show) {
        if ((isOpened() && !show) || (!isOpened() && show))
            startTask(show);
    }

    private static void startTask(boolean show) {
        if (timer.isEmpty()) {
            isFinish = true;
            listener.onStart();
            timer.scheduleTask(initializeTimerTask(show), 0f, INTERVAL_SEC,
                    ((int) (WIDTH / SPEED)));
        }
    }
}