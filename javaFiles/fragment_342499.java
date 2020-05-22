import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Server
{
    ServerSocket serverSocket;
    int portNumber;
    AtomicInteger numClients = new AtomicInteger(0);


    public static void main(String[] args)
    {
        Server s = new Server();

        s.startup();
    }


    /**
     * Start the server on the user picked port
     */
    public void startup()
    {   
        try 
        {
            System.out.println("Enter a port");
            Scanner dif = new Scanner(System.in);
            portNumber = Integer.parseInt(dif.nextLine());
            dif.close();

            serverSocket = new ServerSocket(portNumber);
            newThread();
        }
        catch (IOException e) {
            System.out.println("Error");
            System.exit(0);
        }
    }


    public void newThread()
    {
        Thread thread =new Thread("C"+numClients.getAndIncrement())
        {
            public void run()
            {   
                while(true) {
                    try {
                        accept();
                    } catch (Exception e) {
                        // lof the exception
                    }
                }
            }
        };
        thread.start();
    }

    public void accept()
    {
        try
        {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientSocket(clientSocket)).start();
            System.out.println("A new client has just connected.");
        } catch(IOException e)
        {
            System.out.println("User disconnected");
            System.exit(0);
        }
    }


    class ClientSocket implements Runnable {
        Socket clientSocket;

        public ClientSocket(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            {
                try
                {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String userInput;
                    while ((userInput = in.readLine()) != null)
                    {
                        System.out.println("client: " + userInput);
                    }
                } catch (IOException e)
                {
                    System.out.println("Error. Probably client disconnected");
                    // System.exit(0); do you want to exist when a client disconnects?
                }
            }
        }
    }
}