import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(args[0]);

        Arrays.asList(args).stream().map((s) -> new File(s)).forEach((f) -> {
            if (f.exists()) {
                System.out.println("file " + f + " exits.");
            } else {
                System.out.println("file " + f + " does not exist");
                System.exit(0);
            }
        });
    }

}