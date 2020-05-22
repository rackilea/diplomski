public class Login {
    private GridPane grid;
    private Scene scene;
    private Text title;
    private Label nick;
    private Button wejdzBtn;
    private TextField userName;

    public Login()  {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        scene = new Scene(grid, 300, 150);
        utworzBtn();
        utworzLogin();
        utworzTekst();
        utworzNick();
    }

    private void utworzBtn() {
        wejdzBtn = new Button("Zaloguj si\u0119");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment (Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(wejdzBtn);
        grid.add(hbBtn, 1, 2);
        wejdzBtn.setOnAction(e -> {
            Messages mess = new Messages();
            Window w = scene.getWindow();
            if (w instanceof Stage) {
                Stage s = (Stage) w;
                s.setScene(mess.getScena());
            }
        });
    }

    private void utworzLogin() {
        nick = new Label("Nick:");
        grid.add(nick, 0, 1);
    }

    private void utworzNick() {
        userName = new TextField();
        grid.add(userName,1,1);
        userName.setPromptText("Max 15 znak\u00f3w");
        userName.setFocusTraversable(false);

        final int maxLength = 15;
        userName.setOnKeyTyped(t -> {
            if (userName.getText().length() > maxLength)
            {
                int pos = userName.getCaretPosition();
                userName.setText(userName.getText(0, maxLength));
                userName.positionCaret(pos);
            }
        });
    }

    private void utworzTekst() {
        title = new Text ("Dzień dobry!");
        title.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);
    }

    public Scene okno() {
        return scene;
    }
}