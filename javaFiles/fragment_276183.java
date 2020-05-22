import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Serializable {

    public Client() {
    }

    public void activate() {
        try {
        Socket s = new Socket("localhost",4995);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        while (true)
        {
            String so= br.readLine();
            dout.writeUTF(so);
            System.out.println("client" + so);
            if(so.equalsIgnoreCase("exit"));
            break;
        }
        s.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    /**
     * This number is here for model snapshot storing purpose<br>
     * It needs to be changed when this class gets changed
     */ 
    private static final long serialVersionUID = 1L;

}