import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class TestProject extends SingleFrameApplication {

    @Override protected void startup() {
        show(new AppView(this));
    }

    @Override protected void configureWindow(java.awt.Window root) { }

    public static TestProject getApplication() {
        return Application.getInstance(TestProject.class);
    }

    public static void main(String[] args) {
        launch(TestProject.class, args);
    }
}