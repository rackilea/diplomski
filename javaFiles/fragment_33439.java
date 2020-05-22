import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ImageServer {
    public static void main(String[] args) {
        try {


        Socket socket = new Socket("localhost", 8000);

        //code to send image
        File file = new File("C:\\Users\\ashish\\Desktop\\image.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        int count=0;
        byte[] fileBytes = new byte[(int)file.length()];

        int content;
        OutputStream outputStream = socket.getOutputStream();

        while((content = fileInputStream.read(fileBytes)) != -1){
            outputStream.write(fileBytes, 0, (int)file.length());               
        }

        System.out.println("file size is "+ fileBytes.length);
        for(byte a : fileBytes){System.out.println(a);}           

    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
}