import java.io.*;

public class DummyReader {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new FileReader(new File(args[0])));   
        String line;
        int linecount = 0;
        while((line= br.readLine()) != null){
            System.out.println(line);
            if (System.out.checkError())
            {
                System.err.println("Got some sort of error in the output stream");
                break;
            }
            linecount++;
        }
        br.close();
        System.err.println("Read " + linecount + " lines.");
        System.exit(0);
    }

}