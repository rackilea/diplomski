@Override
public void initialize(URL location, ResourceBundle resources) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("SubView.fxml"));

    try {
        AnchorPane anch1 = loader.load();
        subController = loader.getController();
        Tab1.setContent(anch1);
    } catch (Exception e) {
        System.out.println("unable to load tab1");
        e.printStackTrace();
    }
}