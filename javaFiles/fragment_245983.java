public class Messages {
    private AnchorPane anchor;
    private Scene scena;
    private Button sendBtn;
    private TextField poleDoWpisywania;
    private TextArea poleDoWyswietlania, pobierzNick;

    public Messages() {
        anchor = new AnchorPane();
        scena = new Scene(anchor, 700, 600);
        pobierzNick();
        poleDoWpisywania();
        poleDoWyswietlania();
        utworzPrzycisk();
    }

    private void utworzPrzycisk() {
        sendBtn = new Button("Wy\u015Blij");
        sendBtn.setDisable(true);
    }

    private void pobierzNick() {
        pobierzNick = new TextArea();
        pobierzNick.setEditable(false);
        pobierzNick.setWrapText(true);
    }

    private void poleDoWpisywania() {
        poleDoWpisywania = new TextField();
    }

    private void poleDoWyswietlania() {
        poleDoWyswietlania = new TextArea();
        poleDoWyswietlania.setEditable(false);
        poleDoWyswietlania.setWrapText(true);
    }

    public Scene getScena() {
        return scena;
    }

    public Pane messa() {
        return anchor;
    }
}