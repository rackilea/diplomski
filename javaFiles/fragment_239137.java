import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Testing {

    public static void main(String args[]) throws IOException {
        Scanner s = null;
        try {
            //notice the path is fully qualified path
            s = new Scanner(new File("/tmp/one.txt"));
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}