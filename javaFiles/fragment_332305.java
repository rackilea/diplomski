public class JavaCVTestController {

    @FXML
    private ImageView image;
    @FXML
    private Button btnUpload;

    private ExecutorService exec = Executors.newCachedThreadPool();

    private FileChooser fileChooser = new FileChooser();


    // can't you do this in the FXML?
    public void initialize(URL location, ResourceBundle resources) {
        this.image.setPreserveRatio(true);
    }

    @FXML
    private void uploadImage(ActionEvent Event) throws IOException, Exception{



        File selectedFile = fileChooser.showOpenDialog(image.getScene().getWindow());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgressBar.fxml"));
        Parent root = (Parent) loader.load();

        ProgressBarController pBarController = loader.getController();

        Task<Image> uploadTask = new UploadTask(selectedFile);
        pBarController.progressProperty().bind(uploadTask.progressProperty());
        pBarController.textProperty().bind(uploadTask.messageProperty());

        uploadTask.setOnSucceeded(e -> image.setImage(uploadTask.getValue()));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        exec.execute(uploadTask);
    }
}