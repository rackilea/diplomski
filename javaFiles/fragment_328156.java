public class ImageSelectionController {

    @FXML
    private ImageView imageOne ;

    public void initialize() {
        ImageSelection.getImageSelectionInstance().imageProperty()
            .addListener((obs, oldImage, newImage) -> imageOne.setImage(newImage));
    }

    // ...
}