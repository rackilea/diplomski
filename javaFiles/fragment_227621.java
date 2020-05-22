import java.awt.image.BufferedImage;  //<--- added
import java.io.ByteArrayOutputStream; //<--- added
import java.io.DataOutputStream;      //<--- added
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.ds.fswebcam.FsWebcamDriver;

public class Client {
    private static List<Webcam> webcams = null;
    static Webcam webcam = null;

    static {
        Webcam.setDriver(new FsWebcamDriver());
    }

    public static void main(String[] args) {

    try {
        webcams =(List<Webcam>) Webcam.getWebcams(1000000);
    } catch (Exception e) {
        e.printStackTrace();
    }

    for(Webcam device : webcams){
        String name;
        System.out.println(name = device.getDevice().getName());
        //if(name.equals("Logitech HD Webcam C270 1"))
        webcam = device;
    }
    webcam.setViewSize(WebcamResolution.VGA.getSize());

    webcam.open();

    try{
        Socket socket = new Socket("localhost", 4242);       
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        DataOutputStream dos = new DataOutputStream(out);           //<--- added DataOutputStream
        BufferedImage image = null;                                 //<--- added BufferedImage to keep image from webcam                 
        while(true){

            ByteArrayOutputStream baos = new ByteArrayOutputStream();        //<--- create ByteArrayOutputStream            
            image = webcam.getImage();                                       //<--- get BufferedImage from webcam
            ImageIO.write(image, "png", baos);                               //<--- write image into ByteArrayOutputStream
            dos.writeInt(baos.size());                                       //<--- send image size                                                 
            dos.flush();  //<--- flush DataOutputStream                                                        
            baos.close(); //<--- close ByteArrayOutputStream

            ImageIO.write(image, "png", out);                                    
            out.flush();                                                                                       
            out.write('y');
            out.flush();
            System.out.println("read");
            while(in.read() != 'y');
        }
    }catch(Exception e){
        e.printStackTrace();
    }

    }
}