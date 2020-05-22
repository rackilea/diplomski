@Override
public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("Login.fxml"));
    loader.load();
    Login login = loader.getController();

    Scene loginScene = new Scene(login.getContent(), 1152, 648);