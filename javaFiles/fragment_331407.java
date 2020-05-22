import javafx.scene.image.Image;

/**
 *
 * @author blj0011
 */
public class DieImages
{
    final Image die1 = new Image(getClass().getResourceAsStream("dieRed1.png"));
    final Image die2 = new Image(getClass().getResourceAsStream("dieRed2.png"));
    final Image die3 = new Image(getClass().getResourceAsStream("dieRed3.png"));
    final Image die4 = new Image(getClass().getResourceAsStream("dieRed4.png"));
    final Image die5 = new Image(getClass().getResourceAsStream("dieRed5.png"));
    final Image die6 = new Image(getClass().getResourceAsStream("dieRed6.png"));

    final Image[] images = new Image[6];

    public DieImages()
    {
        images[0] = die1;
        images[1] = die2;
        images[2] = die3;
        images[3] = die4;
        images[4] = die5;
        images[5] = die6;
    }

    public Image[] getImages()
    {
        return images;
    }
}