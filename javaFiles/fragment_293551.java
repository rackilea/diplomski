import java.util.*;

public class CloseScanner {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.in.read();
    }
}