public class Interface extends Application {

public static void main(String[] args) {
    Application.launch(Interface.class, args);
}

private static final int WIDTH = 750;
private static final int HEIGHT = 500;
private static Stage stage;
private static Introduction start;
private static MainDisplay display;
private static Scene startScene;
private static Scene displayScene;

public Interface() {
    start = new Introduction();
    display = new MainDisplay();
    startScene = new Scene(start, WIDTH, HEIGHT);
    displayScene = new Scene(display, WIDTH, HEIGHT);
}

@Override
public void start(Stage primaryStage) throws Exception {
    Interface.stage = primaryStage;

    stage.setTitle(Constants.TITLE);
    stage.setResizable(false);
    stage.setWidth(WIDTH);
    stage.setHeight(HEIGHT);

    stage.setScene(startScene);
    stage.show();
}

public class Introduction extends BorderPane {

    private static final int LOAD = 0;
    private static final int SAVE = 1;
    private Button toGame;
    private Button save;
    public Introduction() {
        setUp();
    }

    private void setUp() {

        this.setBackground(
                new Background(new BackgroundFill(Color.BLACK, null, null)));

        VBox menu = new VBox();
        menu.setSpacing(10);

        Label title = new Label(Constants.TITLE.toUpperCase());
        title.setFont(Font.font("Arial", FontWeight.THIN, 60));
        title.setTextFill(Color.RED);
        menu.getChildren().add(title);

        int btnWidth = 300;
        Background menuBkg = new Background(new BackgroundFill(null, null, null));
        Border menuBorder = new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, new CornerRadii(10), null));

        Button start = new Button(Constants.START.toUpperCase());
        start.setFont(Font.font("Times New Roman", 16));
        start.setTextFill(Color.WHITE);
        start.setPrefWidth(btnWidth);
        start.setBackground(menuBkg);
        start.setBorder(menuBorder);
        start.setOnAction(new StartHandler());

        toGame = new Button(Constants.CONTINUE.toUpperCase());
        toGame.setFont(Font.font("Times New Roman", 16));
        toGame.setTextFill(Color.WHITE);
        toGame.setPrefWidth(btnWidth);
        toGame.setBackground(menuBkg);
        toGame.setBorder(menuBorder);
        toGame.setDisable(true);
        toGame.setOnAction(new ContinueHandler());

        Button load = new Button(Constants.LOAD.toUpperCase());
        load.setFont(Font.font("Times New Roman", 16));
        load.setTextFill(Color.WHITE);
        load.setPrefWidth(btnWidth);
        load.setBackground(menuBkg);
        load.setBorder(menuBorder);
        load.setOnAction(new LoadHandler());

        save = new Button(Constants.SAVE.toUpperCase());
        save.setFont(Font.font("Times New Roman", 16));
        save.setTextFill(Color.WHITE);
        save.setPrefWidth(btnWidth);
        save.setBackground(menuBkg);
        save.setBorder(menuBorder);
        save.setDisable(true);
        save.setOnAction(new SaveHandler());

        Button ranking = new Button(Constants.RANKING.toUpperCase());
        ranking.setFont(Font.font("Times New Roman", 16));
        ranking.setTextFill(Color.WHITE);
        ranking.setPrefWidth(btnWidth);
        ranking.setBackground(menuBkg);
        ranking.setBorder(menuBorder);
        ranking.setOnAction(new RankingHandler());

        Button exit = new Button(Constants.EXIT.toUpperCase());
        exit.setFont(Font.font("Times New Roman", 16));
        exit.setTextFill(Color.WHITE);
        exit.setPrefWidth(btnWidth);
        exit.setBackground(menuBkg);
        exit.setBorder(menuBorder);
        exit.setTooltip(new Tooltip(Constants.EXIT_TOOLTIP));
        exit.setOnAction(new ExitHandler());

        menu.getChildren().addAll(start, toGame, load, save, ranking, exit);
        menu.setAlignment(Pos.CENTER);
        this.setCenter(menu);
    }

    private void performIO(int option) {
        FileChooser chooser = new FileChooser();
        ExtensionFilter ext = new ExtensionFilter(Constants.EXT_DESCRIPTION, ".pt");
        chooser.setSelectedExtensionFilter(ext);
        if (option == LOAD) {
            chooser.setTitle(Constants.LOAD);
            File choice = chooser.showOpenDialog(stage);
        } else if (option == SAVE) {
            chooser.setTitle(Constants.SAVE);
            File choice = chooser.showSaveDialog(stage);
        }
    }

    private boolean verifyRestart() {
        Alert alert = new Alert(AlertType.WARNING, Constants.START_WARNING_MESSAGE,
                ButtonType.YES, ButtonType.NO);
        alert.setTitle(Constants.START_WARNING);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES)
            return true;
        return false;
    }

    private class StartHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (display.isRunning()) {
                if (!verifyRestart())
                    return;
            }

            display.start();
            stage.setScene(displayScene);
            toGame.setDisable(false);
            save.setDisable(false);
        }

    }

    private class ContinueHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            stage.setScene(displayScene);
        }

    }

    private class LoadHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (display.isRunning()) {
                if (!verifyRestart())
                    return;
            }

            performIO(LOAD);
        }

    }

    private class SaveHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            performIO(SAVE);
        }

    }

    private class RankingHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            stage.setScene(displayScene);
        }

    }

    private class ExitHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            performIO(SAVE);
            Platform.exit();
        }

    }

}

public static class MainDisplay extends AnchorPane {

    private boolean running;

    public MainDisplay() {
        running = false;
        tower = new Tower();
        setUp();
    }

    private void setUp() {
        Color blue = new Color(34 / 255, 37 / 255, 47 / 255, 1.0);

        this.setBackground(new Background(new BackgroundFill(blue, null, null)));

        Background bkg = new Background(new BackgroundFill(null, null, null));
        Border menuBorder = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
                new CornerRadii(10), null));

        Button home = new Button(Constants.HOME);
        home.setFont(Font.font("Times New Roman", 10));
        home.setTextFill(Color.WHITE);
        home.setBackground(bkg);
        home.setBorder(menuBorder);
        home.setOnAction(new HomeHandler());
        this.getChildren().add(home);
        AnchorPane.setTopAnchor(home, 10.0);
        AnchorPane.setRightAnchor(home, 10.0);
    }

    public void start() {
        running = true;
    }

    public boolean isRunning() {
        return running;
    }

    private class HomeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            stage.setScene(startScene);
        }

    }

}

}