String imagePath = "http://duke.kenai.com/misc/Bullfight.jpg";
Image image = null;

try 
{
    URL url = new URL(imagePath);
    image = ImageIO.read(url);
} 
catch (IOException e) 
{
     System.out.println(e);
}