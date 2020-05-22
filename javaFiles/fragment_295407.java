import java.awt.Image;

public class DefaultZoomModel extends AbstractZoomModel {
    Image image;

    public DefaultZoomModel(Image image) {
        this.image = image;
    }

    @Override
    public Image getImage() {
        return image;
    }

}