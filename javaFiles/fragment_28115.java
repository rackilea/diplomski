import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackOverflow {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();
        String[] pieces = s.split(" ");

        for (int i = 0; i < pieces.length; i++) {
            try {
                int a = Integer.parseInt(pieces[i]);
                System.out.print(a + " ");
            } catch (Exception e) {
                System.out.printf("%s is not an integer\r\n", pieces[i]);
            }
        }
    }
}