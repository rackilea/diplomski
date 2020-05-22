public class Main extends Application {

    private static Main instance;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        instance = this;
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show(); //Don't show main stage

        JanelaModal modal = new JanelaModal("TEST");
        modal.setWidth(300);
        modal.setHeight(300);
        modal.show();
        popup(modal, "Test message");
    }

    //Copied and pasted from the question post
    public void popup(Window owner, String mensagem) {
        Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);

        Label label = new Label(mensagem);
        label.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));

        popup.getContent().add(label);
        popup.setOnShown((event) -> {
            FadeTransition fade = new FadeTransition(Duration.seconds(5), label);
            fade.setOnFinished((e) -> {
                popup.hide();
            });
            fade.play();
        });

        popup.show(owner);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }
}