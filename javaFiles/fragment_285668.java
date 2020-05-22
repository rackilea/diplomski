import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception
    {
        Client myClient = new Client();
        myClient.run();

    }

    public void run() throws Exception
    {
        Socket clientSocket = new Socket("localhost", 9999);
        //Sends message to the server
        PrintStream ps = new PrintStream(clientSocket.getOutputStream());
        Scanner scan = new Scanner(System.in);
        String cMessage ="";
        InputStreamReader ir = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader br = new BufferedReader(ir);
        while(!(cMessage.trim().equals("END"))){
        cMessage = scan.nextLine();
        ps.println(cMessage);
        //Reads and displays response from server
        String message = br.readLine().trim();
        System.out.println(message);
        }
        br.close();
        ir.close();
        scan.close();
        ps.close();
        clientSocket.close();
    }

}