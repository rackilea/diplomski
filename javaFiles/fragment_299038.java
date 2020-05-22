public class Application extends Controller {

public static Result qrCode() {
    String msg = "I am a QR-String";
    BufferedImage image = (BufferedImage) QR.stringToImage(msg);
    File outputfile = null;

    try{
        outputfile = File.createTempFile("posQR",".png");
        ImageIO.write(image,"png",outputfile);
    }catch(IOException e){
        e.printStackTrace();
    }
    return ok(views.html.qrCode.render(outputfile.getAbsolutePath()));
}
...

public static Result getImage(String imgPath){
    return ok(new File(imgPath));
}
}