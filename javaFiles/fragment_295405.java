import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BoundedRangeModel;

public interface ZoomModel extends BoundedRangeModel {

    public Image getImage();

    public Dimension getScaledSize();

}