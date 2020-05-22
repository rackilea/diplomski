package entry;

import java.io.IOException;
import java.net.ServerSocket;

import server.ServerHandler;

public class Main {
    public static void main(String args[]) throws IOException{
        ServerSocket listener = new ServerSocket(7575);
        try{
            while (true){
                new ServerHandler(listener.accept()).start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            listener.close();
        }
    }
}