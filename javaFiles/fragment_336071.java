import java.util.Observable;
import java.util.Observer;

public class MainClass implements Observer {
    private String keyThatIsPressed;

    @Override
    public void update(Observable observable,
            Object object) {
        if (object instanceof String) {
            this.keyThatIsPressed = (String) object;
            System.out.println("Key that was unlucky enough to get pressed was: "
                    + keyThatIsPressed);
        } 
    }
}