package client2;

import java.io.*;
import java.net.*;
import java.util.*;

public class client2 extends Thread implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String payload;
    private int number; 
    private Random rand;
    public client2(int num){
        rand = new Random();
        this.number = num;
    }

    public void run(){
        try{
            Socket sock = new Socket(InetAddress.getLocalHost(),(12345+this.number));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            for (int i=0; i<30; i++){
                String random = Integer.toString(this.rand.nextInt());
                this.payload = "thread[" + this.number + "]&"+random; 
                pw.write(this.payload);
                pw.write("\n");
                pw.flush();
                }
            sock.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}