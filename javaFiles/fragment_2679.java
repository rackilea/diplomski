public class Main extends Application {
Stage window;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {

    window = primaryStage;
    window.setTitle("Sample");
    GridPane grid = new GridPane();
    User usr1 = new User("Witold", "ciastko");
    User usr2 = new User("Michał", "styk");
    User usr3 = new User("Maciej", "masloo");
    ComboBox<User> combo1 = new ComboBox<User>();
    combo1.getItems().addAll(usr1, usr2, usr3);
    combo1.setConverter(new StringConverter<User>() {
        @Override
        public String toString(User usr) {
            return usr == null ? "" : usr.getName();
        }

        @Override
        public User fromString(String s) {
            User usr = new User(s, "haslo");
            return usr;
        }
    });
    combo1.setEditable(true);
    combo1.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
        if (e.getCode() == KeyCode.ENTER) {
            combo1.getItems().add(combo1.getValue());
        }

    });
    GridPane.setConstraints(combo1, 2, 1);
    grid.getChildren().addAll(combo1);
    Scene scene = new Scene(grid, 400, 200);
    window.setScene(scene);
    window.show();

}