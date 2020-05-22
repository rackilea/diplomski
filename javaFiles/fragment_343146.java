import java.io.BufferedWriter;
import java.io.FileWriter;

public class RandomNumber {

    public static void main(String[] args) {

    try {

        int n = 10000;
        String line = "";
        for (int i = 0; i < n; i++) {
            int temp = (int) Math.ceil((Math.random() * n));
            line = line+temp+" ";
            System.out.println(line);
        }

        System.out.println("file name is :: input" + n + ".txt");
        FileWriter fstream = new FileWriter("input" + n + ".txt");
        BufferedWriter out = new BufferedWriter(fstream);
        // till here you were correct.
        // you don't need the loop here...
        out.write(line);
        out.close();
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
    }
}