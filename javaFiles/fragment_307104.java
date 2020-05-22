import java.util.*;
import java.io.*;

public class Parse {
    public static final void main(String[] args) {
        try {
            String result = test(45);
            System.out.println("result = " + result);
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static String test(int numVol)throws Exception{
        File file = new File("test.csv");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(";"); // <== Just using ";"
        String line = "";
        String sNumVol = ""+numVol;
        while (scanner.hasNext()){
            line = scanner.next();
            System.out.println("line = [[" + line + "]]");
            if(line.equals(sNumVol)){
                scanner.close();
                return line;
            }
        }
        scanner.close();
        return line;
    }
}