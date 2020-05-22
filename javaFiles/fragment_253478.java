import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationControl {
    private final TranslateTransition translateTransition;

    public AnimationControl(Duration duration, Node node) {
        translateTransition = new TranslateTransition(duration, node);
    }

    public TranslateTransition getTranslateTransition() {
        return translateTransition;
    }
}