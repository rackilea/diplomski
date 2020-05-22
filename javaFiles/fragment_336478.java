import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @se http://stackoverflow.com/a/37154103/230513
 */
public class Main extends Application {

    Label sample, USCS, ColorField, DensityLabel, MoistureField,
        startElevationField, endElevationField, BlowCount6Field,
        BlowCount12Field, BlowCount18Field, LabTestField,
        SamplerTypeField;

    TextField sampleTextField, USCSTextField, ColorTextField,
        DensityTextField, MoistureTextField,
        startElevationTextField, endElevationTextField,
        BlowCount6TextField, BlowCount12TextField,
        BlowCount18TextField, LabTestTextField,
        SamplerTypeTextField;

    int rowMod, columnMod;

    GridPane grid = new GridPane();
    private int row;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Boring Logger+");
        grid.add(createGrid(), 0, row);
        ScrollPane sp = new ScrollPane(grid);
        sp.setHbarPolicy(ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        BorderPane bp = new BorderPane(sp);
        HBox hbox = new HBox(createButton());
        hbox.setAlignment(Pos.CENTER_RIGHT);
        bp.setBottom(hbox);
        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        sample = new Label("Sample Label");
        grid.add(sample, 0, 3);
        sample.setPrefWidth(150);
        sample.setAlignment(Pos.CENTER);

        sampleTextField = new TextField();
        grid.add(sampleTextField, 0, 4);

        USCS = new Label("USCS");
        grid.add(USCS, 1, 0);
        USCS.setPrefWidth(150);
        USCS.setAlignment(Pos.CENTER);

        USCSTextField = new TextField();
        grid.add(USCSTextField, 1, 1);

        ColorField = new Label("Color");
        grid.add(ColorField, 2, 0);
        ColorField.setPrefWidth(150);
        ColorField.setAlignment(Pos.CENTER);

        ColorTextField = new TextField();
        grid.add(ColorTextField, 2, 1);

        DensityLabel = new Label("Density");
        grid.add(DensityLabel, 3, 0);
        DensityLabel.setPrefWidth(150);
        DensityLabel.setAlignment(Pos.CENTER);

        DensityTextField = new TextField();
        grid.add(DensityTextField, 3, 1);

        MoistureField = new Label("Moisture");
        grid.add(MoistureField, 4, 0);
        MoistureField.setPrefWidth(150);
        MoistureField.setAlignment(Pos.CENTER);

        MoistureTextField = new TextField();
        grid.add(MoistureTextField, 4, 1);

        startElevationField = new Label("Start Elevation");
        grid.add(startElevationField, 1, 3);
        startElevationField.setPrefWidth(150);
        startElevationField.setAlignment(Pos.CENTER);

        startElevationTextField = new TextField();
        grid.add(startElevationTextField, 1, 4);

        endElevationField = new Label("End Elevation");
        grid.add(endElevationField, 2, 3);
        endElevationField.setPrefWidth(150);
        endElevationField.setAlignment(Pos.CENTER);

        endElevationTextField = new TextField();
        grid.add(endElevationTextField, 2, 4);

        BlowCount6Field = new Label("Blow Count @ 6in");
        grid.add(BlowCount6Field, 3, 3);
        BlowCount6Field.setPrefWidth(150);
        BlowCount6Field.setAlignment(Pos.CENTER);

        BlowCount6TextField = new TextField();
        grid.add(BlowCount6TextField, 3, 4);

        BlowCount12Field = new Label("Blow Count @ 12in");
        grid.add(BlowCount12Field, 4, 3);
        BlowCount12Field.setPrefWidth(150);
        BlowCount12Field.setAlignment(Pos.CENTER);

        BlowCount12TextField = new TextField();
        grid.add(BlowCount12TextField, 4, 4);

        BlowCount18Field = new Label("Blow Count @ 18in");
        grid.add(BlowCount18Field, 1, 5);
        BlowCount18Field.setPrefWidth(150);
        BlowCount18Field.setAlignment(Pos.CENTER);

        BlowCount18TextField = new TextField();
        grid.add(BlowCount18TextField, 1, 6);

        LabTestField = new Label("Lab Test?");
        grid.add(LabTestField, 2, 5);
        LabTestField.setPrefWidth(150);
        LabTestField.setAlignment(Pos.CENTER);

        LabTestTextField = new TextField();
        grid.add(LabTestTextField, 2, 6);

        SamplerTypeField = new Label("Sampler Type");
        grid.add(SamplerTypeField, 3, 5);
        SamplerTypeField.setPrefWidth(150);
        SamplerTypeField.setAlignment(Pos.CENTER);

        SamplerTypeTextField = new TextField();
        grid.add(SamplerTypeTextField, 3, 6);

        return grid;
    }

    public Button createButton() {
        Button btn = new Button("Add Sample");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                grid.add(createGrid(), 0, ++row);
            }
        });
        return btn;
    }
}