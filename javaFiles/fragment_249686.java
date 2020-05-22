public class Ana extends Application{

    private Stage window;
    private BorderPane layout;

    @Override
    public void start(Stage args) throws Exception {
        try{
            window = args;
            Controller mainController = showMainView();
            Controller2 controller = showMainItems();
            mainController.setData(controller.getData());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    private Controller showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Ana.class.getResource("interface.fxml"));
        layout = loader.load();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
        return loader.getController();
    }

    private Controller2 showMainItems() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Ana.class.getResource("interface2.fxml"));
        BorderPane layout2 = loader.load();
        layout.setCenter(layout2);
        return loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}