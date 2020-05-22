import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author blj0011
 */
public class Die
{
    ImageView dieFace;
    Image[] images;

    public Die(Image[] images)
    {
        this.images = images;
        dieFace = new ImageView(this.images[0]);//set default to image 0
    }

    public Die(Image[] images, int dieFaceValue)
    {
        //Need to catch for values less than 1 and greater than 6!
        this.images = images;
        dieFace = new ImageView(this.images[dieFaceValue - 1]);
    }

    public ImageView getdieFace()
    {
        return dieFace;
    }

    public void setDieFace(int dieFaceValue)
    {
        //Need to catch for values less than 1 and greater than 6!
        dieFace.setImage(this.images[dieFaceValue - 1]);
    }
}