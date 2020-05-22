import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainController{

    @FXML
    private Pane containerPane;
    @FXML
    private Button add;

    private static int counter = 0;

    @FXML
    private void initialize(){
        add.setOnAction(e -> addNode());
    }

    private void addNode() {

        FXMLLoader loader = new FXMLLoader();
        try {
            Node node  =  loader.load(getClass().getResource("NodeTemplate.fxml").openStream());
            containerPane.getChildren().add(node);
            //get the controller 
            NodeTemplateController controller = (NodeTemplateController)loader.getController();
            controller.setContent("Node number "+ counter++); //set label 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}