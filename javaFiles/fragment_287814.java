import java.io.IOException;

public class ControlFlowTest {
    public static void main(String[] args) throws java.io.IOException {
        char ch ;

        Scanner scanner= new Scanner(System.in);
        do {
            ch = scanner.next().charAt(0);
        } while(ch != '.');
    }
}