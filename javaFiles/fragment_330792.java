public class TableBlock extends VBox{

    private final String rowsFromPrefs;

    @FXML
    private Label label;

    public TableBlock(@NamedArg("rowsFromPrefs") String rowsFromPrefs) {

        this.rowsFromPrefs = rowsFromPrefs ;
        FXMLLoader fxmlLoader = new   FXMLLoader(getClass().getResource("TableBlock.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        this.table = createTable(rowsFromPrefs);
    }

    public String getRowsFromPrefs() {
        System.out.println("getRowsFromPrefs");
        return rowsFromPrefs;
    }


}