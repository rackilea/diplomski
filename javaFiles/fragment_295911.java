import java.io.InputStreamReader; // Reported unused import

public class TestJava {
    public static void main(String[] args) {

        String input = null;
        String unused; // DID NOT report unused variable

        System.out.println("Input "+ input); // Reported usage of null
    }
}