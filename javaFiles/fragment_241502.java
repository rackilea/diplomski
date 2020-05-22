import java.io.IOException;
import java.net.ServerSocket;

public class OneInstance {

    private static ServerSocket SERVER_SOCKET;

    public static void main(String[] args) {
        try {
            SERVER_SOCKET = new ServerSocket(1334);
            System.out.println("OK to continue running.");
            System.out.println("Press any key to exit.");
            System.in.read();
        } catch (IOException x) {
            System.out.println("Another instance already running... exit.");
        }
    }
}