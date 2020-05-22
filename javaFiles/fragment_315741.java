public class SampleClass
{
    static String imgpath = "/theimage.png";

    public static void main(String[] args)
    {
        System.out.println(imgpath);
        System.out.println(SampleClass.class.getResource(imgpath));
        try
        {
            BufferedImage image = ImageIO.read(SampleClass.class.getResource(imgpath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}