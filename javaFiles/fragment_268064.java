import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TableBar extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        ObservableList<Data> data = FXCollections.observableArrayList();
        for (int i = 0; i<10; i++) data.add(new Data());

        TableView<Data> tv = new TableView(data);
        TableColumn<Data, Number> col1 = new TableColumn("num1");
        TableColumn<Data, Number> col2 = new TableColumn("num2");
        col1.setCellValueFactory((p)->{return p.getValue().num1;});
        col2.setCellValueFactory((p)->{return p.getValue().num2;});

        //make this column hold the entire Data object so we can access all fields
        TableColumn<Data, Data> col3 = new TableColumn("bar");
        col3.setPrefWidth(100);
        col3.setCellValueFactory((p)->{return new ReadOnlyObjectWrapper<>(p.getValue());});
        col3.setCellFactory((TableColumn<Data, Data> param) -> {
            return new TableCell<Data, Data>(){

                @Override
                protected void updateItem(Data item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) setGraphic (null);
                    else {
                        double tot = item.num1.get() + item.num2.get();
                        double ratio1 = item.num1.get() / tot;
                        double ratio2 = item.num2.get() / tot;

                        Rectangle r1 = new Rectangle();
                        //the param is the column, bind so rects resize with column
                        r1.widthProperty().bind(param.widthProperty().multiply(ratio1));
                        r1.heightProperty().bind(this.getTableRow().heightProperty().multiply(0.5));
                        r1.setStyle("-fx-fill:#f3622d;");
                        Rectangle r2 = new Rectangle(0, 20);
                        r2.widthProperty().bind(param.widthProperty().multiply(ratio2));
                        r2.setStyle("-fx-fill:#fba71b;");

                        HBox hbox = new HBox(r1,r2);
                        hbox.setAlignment(Pos.CENTER_LEFT);
                        setGraphic(hbox);
                        setText(null);
                    }
                }

            };
        });

        tv.getColumns().addAll(col1,col2,col3);
        Scene scene = new Scene(tv);

        stage.setScene(scene);
        stage.show();
    }

    class Data{
        private SimpleIntegerProperty num1 = new SimpleIntegerProperty((int)(Math.random()*1000));
        private SimpleIntegerProperty num2 = new SimpleIntegerProperty((int)(Math.random()*1000));

        public SimpleIntegerProperty num1Property(){return num1;}
        public SimpleIntegerProperty num2Property(){return num2;}
    }
}