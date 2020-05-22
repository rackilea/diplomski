public class FXMLStage extends Stage implements Initializable {

    protected URL url = null;
    protected ResourceBundle resourceBundle = null;

    @SuppressWarnings("LeakingThisInConstructor")
    public FXMLStage(String filename) {
        final FXMLLoader loader = new FXMLLoader(FXMLLoader.class.getResource(filename));
        try {
            loader.setControllerFactory(p -> this);
            this.setScene(new Scene(loader.load()));
        } catch (IOException ex) {
            throw new InternalApplicationError("Resource missing", ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.resourceBundle = rb;
    }
}