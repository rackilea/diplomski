package server2;

import java.io.*;
import java.net.*;
import java.util.*;

public class server extends Thread implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int port;
    private static String data = "nothing yet";
    public server(int port){
        this.port = port;
        System.out.println("Server thread["+(this.port-12345)+"] started");
    }

    public void run(){
        try{
            ServerSocket sock = new ServerSocket(this.port, 50, InetAddress.getLocalHost());
            Socket accepted = sock.accept();                
            BufferedReader br = new BufferedReader(new InputStreamReader(accepted.getInputStream()));
            while(br.readLine() !=null){
                synchronized(data){
                    updateData(br.readLine());
                }
                if (br.readLine() == null) break;
            }
            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }

    private void updateData(String streamObj){
        String[] streamArr = streamObj.split("&");
        data = streamArr[1];
        System.out.println("Data updated to "+data+" by "+streamArr[0]+" @ "+ new Date());
    }
}