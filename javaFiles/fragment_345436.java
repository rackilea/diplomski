import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneExample extends Application{

    @Override
    public void start(Stage ps) throws Exception {

        VBox content = new VBox(); // create a VBox to act like a graphic content for the Tab

        ///////////////////////////////////////////
        Label label = new Label("Text"); 
        label.setAlignment(Pos.BOTTOM_CENTER);

        ImageView icon = new ImageView(new Image("file:C:\\Users\\Yahya\\Desktop\\icon.png")); // for example
        icon.setFitWidth(25); icon.setFitHeight(25); // your preference
        ///////////////////////////////////////////

        // add the components to the VBox
        // You can set the Margins between the children ..etc
        content.getChildren().addAll(icon, label);
        //content.setAlignment(Pos.BOTTOM_CENTER);

        Tab tab = new Tab();// create a Tab object and set the Graphic 
        tab.setGraphic(content);

        // create TabPane, set side to left
        // all other values need manipulation (i.e. up to your preference)
        TabPane tabPane = new TabPane(tab);
        tabPane.setSide(Side.LEFT);

        // just simple root to see the result
        Pane root = new Pane();
        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 300,300);
        ps.setScene(scene);
        ps.show();
    }

    public static void main(String[] args){
        launch();
    }

}