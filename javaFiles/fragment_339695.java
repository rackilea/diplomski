public class DocumentModule extends GridPane implements Initializable {
      protected Document document;

    @FXML
    private DocumentView documentView;

    @FXML
    private ScrollPane scrollPane;
    .
    .
    .
    public DocumentModule() {
          System.out.println("Document Module constructed.");

          FXMLLoader loader = new FXMLLoader(getClass().getResource("document_module.fxml"));
          loader.setRoot(this);
          loader.setController(this);
          try {
              loader.load();
          } catch (IOException exc) {
              exc.printStackTrace();
              // this is pretty much fatal, so:
              System.exit(1);
         }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         System.out.println("Document Module initialized.");
         // This will now be called after the @FXML-annotated fields are initialized.
    }

}