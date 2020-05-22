import org.jemmy.TimeoutExpiredException;
import org.jemmy.fx.SceneDock;
import org.junit.Test;

public class TestX {

    @Test
    public void notInitializedToolkit() {
        try {
            new SceneDock();

        } catch (TimeoutExpiredException e) {
            System.err.println("The application have not been launched");
        }
    }
}