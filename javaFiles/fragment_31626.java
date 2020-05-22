package example;

import java.io.IOException;
import java.io.InputStream;

public class YMain {

    public static void main(String[] args) throws IOException {
        // Fetch and print message from X
        InputStream fromx = YMain.class.getClassLoader().getResourceAsStream("fromx.txt");
        System.out.println(new String(Util.toByteArray(fromx)));

        // Print first command line argument
        System.out.println(args[0]);
    }
}