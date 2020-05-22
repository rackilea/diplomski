import java.util.*;
import java.io.*;
public class try13 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(args[0]);
        Scanner in = new Scanner(inputFile);

        /* Create all the writers and put then in a list */
        List<PrintWriter> writers = new ArrayList<>();
        for(int i = 1; i < args.length; i++) {
            writers.add(new PrintWriter(args[i]));
        }

        /* Read each line and write it to all writers */
        while (in.hasNextLine()) {
            String line = in.nextLine();
            writers.forEach(writer -> writer.println(line));
        }

        in.close();

        /* Close all the writers */
        writers.forEach(writer -> {
                try {
                    writer.close();
                } catch(Exception e) {}
        });
    }
}