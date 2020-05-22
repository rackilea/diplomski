public class detectController {

    //....

    @FXML
    private TableView<detectBean> tableView;
    ObservableList<detectBean> list;
    ///....

   /////////////////////////////////////////////////////

@FXML
void doFetch(ActionEvent event) throws IOException{

    String a = recall();
    txtSTID.setText(a);
    ObservableList<detectBean> list=getRecordsFromTableSome(a);
    /// here!!!
    // tableView.setItems(list);
    tableView.getItems().addAll(list);

}