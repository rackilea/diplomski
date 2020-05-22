import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class otpcheck extends HttpServlet {



@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {


    Crypting c=new Crypting();
    BufferedImage imgKey;
    BufferedImage imgEnc;
    imgKey = ImageIO.read(new File("E:/Key.png"));
    imgEnc=ImageIO.read(new File("E:/upload/E.png"));
     BufferedImage imgDec=Crypting.decryptImage(imgKey,imgEnc);
    response.setContentType("image/png");
    OutputStream os=response.getOutputStream();
    ImageIO.write(imgDec,"png",os);
}
}