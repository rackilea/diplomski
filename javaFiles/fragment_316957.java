import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        StringBuffer sb = new StringBuffer();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            sb.append(line).append("\n");
        }       

        String[] blocks = sb.toString().split("\n\n");

        for (String block : blocks) {
            block = block.trim();
            // block - individual block from file
            String[] data = block.split("\n");
            for (String d : data) {
                // d - individual line of block 
            }   
        }   
    }    
}