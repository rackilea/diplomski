import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LogScanner
{

    public static void main(String[] args) throws FileNotFoundException
    {
        FileInputStream inputStream = null;
        Scanner sc = null;

        String path = "D:\\hadoopTest.log";
        String blockStart= ".*\\[MAP\\].*";
        String blockEnd = ".*\\[\\\\MAP\\].*";
        boolean inBlock = false;
        StringBuilder block = null;

        inputStream = new FileInputStream(path);
        sc = new Scanner(inputStream, "UTF-8");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.matches(blockStart)) {
                inBlock = true;
                block = new StringBuilder();
            }

            if (inBlock) {
                block.append(line);
                block.append("\n");
            }

            if (line.matches(blockEnd)) {
                inBlock = false;
                String completeBlock = block.toString();
                System.out.println(completeBlock);
                // I'm outputting the blockto stdout, you could append to a file\whatever.
            }
        }

        sc.close();
    }
}