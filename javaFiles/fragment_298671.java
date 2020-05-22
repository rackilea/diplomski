package password;

import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {
        Password pass = new Password();

        pass.creator();
        pass.readit();
        pass.checkit();
    }
}