public class ImageContainer extends Pane {

private static final PATH_FXML = "/internal/path/to/layout.fxml"

@FXML public HBox hbx_elementContainer;
@FXML public Label lb_likeCount;
@FXML public Label lb_commentCount;
@FXML public Label lb_location;

public ImageContainer(int likeCount, int commentCount, String location) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH_FXML));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
        fxmlLoader.load();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    this.lb_likeCount.setText(String.valueOf(likeCount));
    this.lb_commentCount.setText(String.valueOf(commentCount));
    this.lb_location.setText(location);

    Image image = new Image("/sampleFoto.JPG");
    iv_feedImage.setImage(image);
}
}