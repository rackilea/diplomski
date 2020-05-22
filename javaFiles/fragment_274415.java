import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication287 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        ObservableList observableList = FXCollections.observableArrayList(Font.getFamilies());
        GridView<String> myGrid = new GridView(observableList);
        myGrid.setHorizontalCellSpacing(0);
        myGrid.setVerticalCellSpacing(0);
        myGrid.setCellFactory(gridView -> {
            return new GridCell<String>()
            {
                Button button = new Button("ABC");

                {
                    button.setPrefWidth(60);
                    button.setPrefHeight(60);
                }

                @Override
                public void updateItem(String item, boolean empty)
                {
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    }
                    else {
                        button.setFont(new Font(item, 14));
                        setGraphic(button);
                    }

                }
            };
        });

        StackPane root = new StackPane(myGrid);
        Scene scene = new Scene(root, 500, 700);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}