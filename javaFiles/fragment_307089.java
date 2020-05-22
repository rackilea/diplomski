import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class testController {

    //Variable initialization
    @FXML
    TableView<TestObj> tvTest;
    @FXML
    TableColumn<TestObj, Integer> keyCol;
    @FXML
    TableColumn<TestObj, String> aCol;
    @FXML
    TableColumn<TestObj, String> bCol;
    @FXML
    TableColumn<TestObj, String> cCol;

    ObservableList<TestObj> testObjs= FXCollections.observableArrayList();

    //Creates cell factories and loads up lists
    public void initialize(){
        //Cell value factory creation
        keyCol.setCellValueFactory(new PropertyValueFactory<TestObj,Integer>("key"));
        aCol.setCellValueFactory(new PropertyValueFactory<TestObj,String>("A"));
        bCol.setCellValueFactory(new PropertyValueFactory<TestObj,String>("B"));
        cCol.setCellValueFactory(new PropertyValueFactory<TestObj,String>("C"));

        //Test objects
        testObjs.add(new TestObj(1,"A1","B1","C1"));
        testObjs.add(new TestObj(2,"A2","B2","C2"));
        testObjs.add(new TestObj(3,"A3","B3","C3"));

        tvTest.setItems(testObjs);
    }
}