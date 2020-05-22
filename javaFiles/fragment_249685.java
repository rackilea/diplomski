public class Controller implements Initializable {

    private ObservableList<Product> data ;

    public ObservableList<Product> getData() {
        return data ;
    }

    public void setData(ObservableList<Product> data) {
        this.data = data ;
    }

    // ...

    @FXML
    void addClicked(ActionEvent event) {
        data.add(new Product(txtf1.getText(), txtf2.getText(), txtf3.getText());
    }

    // etc ...
}