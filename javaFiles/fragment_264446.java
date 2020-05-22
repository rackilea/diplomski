import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread
{
    public static final int SERVER_PORT = 4444;
    private boolean running = false;
    private PrintWriter mOut;
    private OnMessageReceived mMessageListener = null;
    private boolean mRun = false;
    PrintWriter out;

    public TCPServer(OnMessageReceived listener){
        this.mMessageListener = listener;
    }


    public static void main(String[] args) 
    {
        ServerBoard frame = new ServerBoard();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void sendMessage(String message){
        if(mOut != null && !mOut.checkError()){
            mOut.print(message);
            mOut.flush();
        }
    }

    @Override
    public void run(){
        super.run();
        running = true;

        try{
            System.out.println("S: Connecting...");
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket client = serverSocket.accept();
            System.out.println("S: Receiving...");

            try{
                mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                while(running){
                    String msg = in.readLine();
                    if(msg != null && mMessageListener != null){
                        mMessageListener.messageReceived(msg);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public interface OnMessageReceived
    {
        public void messageReceived(String message);
    }
}