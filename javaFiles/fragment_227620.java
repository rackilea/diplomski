import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream; //<--- added
import java.io.DataInputStream;      //<--- added
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Server extends Thread{

private ServerSocket mServer_Socket;
private ArrayList<SocketManager> managers = new ArrayList<SocketManager>();

public Server(){
    try {
        mServer_Socket = new ServerSocket(4242);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public void run() {
    Socket msocket;
    try{
        msocket = mServer_Socket.accept();
        System.out.println("connected");
        managers.add(new SocketManager(msocket));
    }catch(Exception e){
        e.printStackTrace();
    }
}

public void SendMessage(String m, int i){
    try {
        managers.get(i).write(m.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private class SocketManager{
    private OutputStream mout;
    private InputStream min;
    private DataInputStream din; //<--- added DataInputStream    

    public SocketManager(Socket socket){
        try{
            mout = socket.getOutputStream();
            min = socket.getInputStream(); 
            din = new DataInputStream(min); //<--- initialized DataInputStream

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        startListen();
    }

    public void write(byte[] data) throws IOException{
        mout.write(data);
    }


    public void startListen()
    {
        new Thread() {                                   
            BufferedImage image;
            public void run(){
                try {                   
                    System.out.println("listen..");                                                                                                           
                    while(true)
                    {
                        int arrlen = din.readInt();  //<--- receive image size in order to prepare a buffer for it                      
                        byte[] b = new byte[arrlen]; //<--- prepare a buffer
                        din.readFully(b);            //<--- receive image data

                        while(min.read() != 'y');                                                                  
                        mout.write('y');                       
                        mout.flush();

                        InputStream bais = new ByteArrayInputStream(b); //<--- get ByteArrayInputStream from buffer
                        BufferedImage image = ImageIO.read(bais);       //<--- prepare BufferedImage from ByteArrayInputStream 
                        bais.close();                                   //<--- close ByteArrayInputStream

                        Main.drawImage(image);  

                    }//end while true

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }


    }


}