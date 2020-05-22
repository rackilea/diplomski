package dynamictable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class DynamicTable extends Application{

    private ObservableList<ObservableList<String>> data;
    private TableView<ObservableList<String>> tableview;


    //CONNECTION DATABASE
    public void buildData() {
        data = FXCollections.observableArrayList();
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            Connection c = DriverManager.getConnection("jdbc:h2:mem:");
            //or you can use derby in your jdk folder
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            //Connection c = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true");

            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE CUSTOMER (num INTEGER, name VARCHAR(255), address VARCHAR(255))";
            stmt.executeUpdate(sql);
            for (int i = 0; i < 10; i++) {
                sql = "INSERT INTO CUSTOMER VALUES (" + i + ",'1st string in row " + i + "','2nd string in row " + i + "')";
                stmt.executeUpdate(sql);
            }
            //c = DBConnect.connect();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from CUSTOMER";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
              *********************************
             */
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList<String>, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j));
                    }
                });

                tableview.getColumns().add(col);

                Callback<TableColumn<Map, String>, TableCell<Map, String>> cellFactoryForMap 
                        = new Callback<TableColumn<Map, String>, TableCell<Map, String>>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        return new TextFieldTableCell(new StringConverter() {
                            @Override
                            public String toString(Object t) {
                                return t.toString();
                            }

                            @Override
                            public Object fromString(String string) {
                                return string;
                            }
                        });
                    }
                };

                if (j != 1) {
                    col.setCellFactory(cellFactoryForMap);
                }

                System.out.println("Column [" + i + "] ");
            }

            /**
             * ******************************
             * Data added to ObservableList *
             *******************************
             */
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }

            rs.close();
            c.close();
            //FINALLY ADDED TO TableView
            tableview.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
    //TableView

        tableview = new TableView();
        tableview.setEditable(true);
        tableview.getSelectionModel().setCellSelectionEnabled(true);
        buildData();

        //Main Scene
        Scene scene = new Scene(tableview);

        stage.setScene(scene);
        stage.show();
        tableview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (tableview.getSelectionModel().getSelectedItem() != null) {
                    TableViewSelectionModel selectionModel = tableview.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    System.out.println("Selected Value " + val);
                    System.out.println("Selected row " + newValue);
                }
            }
        });

        System.out.println("");
        System.out.println("List all data without using table");
        for (ObservableList<String> ol : data){
            System.out.print("row-> ");
            for (String s : ol){
                System.out.print(s+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Show data at specific location in data");
        System.out.println(" row 6 (index 5), column 2(index 1) -> "+data.get(5).get(1));

        System.out.println("");
        System.out.println("Show data at specific location in table");
        System.out.println(" row 2, col 2 -> "+tableview.getItems().get(1).get(1));
    }

    public static void main(String[] args) {
        launch(args);
    }

}