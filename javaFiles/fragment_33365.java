import java.util.Random;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost", 7654);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 0; i < 11; i++) {
                out.println(Stringer()); //<-- println instead of write
            }
            socket.close();
        } // end of connection try block
        catch(Exception e) {
            System.out.print(e.toString());
        }

    } //end of main

    static String Stringer() {
        String msg, alpha;
        msg = "";
        alpha = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            msg += alpha.charAt(rnd.nextInt(25));
        }
        return msg;
    }
} //end of class