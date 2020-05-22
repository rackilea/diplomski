import java.net.URL;
import javax.swing.ImageIcon;

public class Example {

    public ImageIcon getImage() {
        URL url = Example.class.getResource( "image.png" );
        if( url != null ) {
            return new ImageIcon( url );
        }
        return null; // TODO: Better error handling
    }

}