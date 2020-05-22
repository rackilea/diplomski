package populatetable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DialogController  {


    private ObservableList<Data> appMainObservableList;

    //fill table button click event
    @FXML
    void fillTable(ActionEvent event) {

        Data data = new Data(1, "Name1");
        appMainObservableList.add(data);

    }

    public void setAppMainObservableList(ObservableList<Data> tvObservableList) {
        this.appMainObservableList = tvObservableList;

    }

}