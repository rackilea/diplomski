import java.util.List;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ReelPane extends Pane {

    private List<Node> managed;
    private double dy, numberOfCchildren;
    private boolean isAnimating = false;
    private static final double PAUSE = 1;

    @Override
    protected void layoutChildren() {

        if(isAnimating) return;
        managed = getChildren();
        numberOfCchildren = managed.size();
        double y = 0;
        for (Node node : managed) {
            node.setLayoutX(0);
            node.setLayoutY(y);
            dy = Math.max(dy, node.getBoundsInLocal().getHeight()); //dy stores the highest
            y += dy;
        }
    }
    public void spin() {

        isAnimating = true;
        PauseTransition pause = new PauseTransition(Duration.seconds(PAUSE));
        pause.setOnFinished(event ->{
            for (Node node : managed) {

                if(node.getLayoutY()>= (numberOfCchildren -1) * dy){
                    node.setLayoutY(-dy);
                }
                node.setLayoutY(node.getLayoutY() +dy);
            }
            pause.play();
        });

        pause.play();
    }
}