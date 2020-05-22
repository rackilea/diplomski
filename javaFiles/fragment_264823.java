package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerHandler extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private ArrayList<Socket> clients;

    public ServerHandler(Socket socket) throws IOException{
        this.socket = socket;
        clients = new ArrayList<Socket>();
        if (!clients.contains(socket)){
            clients.add(this.socket);
            System.out.println(this.socket.getRemoteSocketAddress());
        }
    }

    @Override
    public void run(){
        while (true){
            if (clients.isEmpty()) break;
            String str = null;
            for (int i = 0; i < clients.size(); i++){
                Socket socket = clients.get(i);
                if (socket.isClosed()){
                    clients.remove(socket);
                    continue;
                }
                try {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                try {
                    out = new PrintWriter(socket.getOutputStream(), true);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    str = in.readLine();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                out.println(str.toUpperCase());
            }
        }
    }
}