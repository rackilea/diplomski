import java.util.ArrayList;
import java.util.List;

public class Example
{
    public abstract ImageVideo
    {

    }

    public class Image extends ImageVideo
    {

    }

    public class Video extends ImageVideo
    {

    }

    public static class Media
    {
        public static void main( String args[] )
        {
            Image image = new Example().new Image();
            Video video = new Example().new Video();

            List<ImageVideo> mediaList = new ArrayList<ImageVideo>();

            mediaList.add( image );
            mediaList.add( video );
        }
    }
}