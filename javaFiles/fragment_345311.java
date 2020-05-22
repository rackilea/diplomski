public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


            ListView<User> listView = new ListView<User>();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            ObservableList<User> users = FXCollections.observableArrayList();
            users.addAll(new User("Bruce", "Is strong", sdf.parse("24/12/1975")),
                    new User("Claire", "Is clever", sdf.parse("02/01/1986")), 
                    new User("Bale", "Is funny", sdf.parse("03/01/1989")));

            listView.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {

                @Override
                public ListCell<User> call(ListView<User> param) {
                    return new ListCell<User>(){

                        @Override
                        protected void updateItem(User item, boolean empty) {

                            super.updateItem(item, empty);
                            if(item != null){

                                HBox mainPane = new HBox();
                                ImageView image = new ImageView(new Image(getClass().getResource("close_icon.png").toExternalForm(),
                                        20, 20, true, true));

                                Label nick = new Label(item.nickProperty().get());
                                Label text = new Label(item.textProperty().get());

                                VBox vBox = new VBox();
                                vBox.getChildren().addAll(nick, text);

                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                                Label time = new Label(dateFormat.format(item.timeProperty().get()));

                                mainPane.getChildren().addAll(image, vBox, time);

                                setGraphic(mainPane);

                            }
                        }

                    };
                }
            });

            listView.setItems(users);

            root.setCenter(listView);


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}