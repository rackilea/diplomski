import java.util.ArrayList;
import java.util.List;

public class Example
{
    public class Image
    {

    }

    public class Video
    {

    }

    public static class Media
    {
        public static void main( String args[] )
        {
            Image image = new Example().new Image();
            Video video = new Example().new Video();

            List<Object> mediaList = new ArrayList<Object>();

            mediaList.add( image );
            mediaList.add( video );
        }
    }
}