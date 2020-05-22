import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    StringBuilder sb = new StringBuilder();

    StringTokenizer tokenizer;

    public static void main(String[] args){
        Main main = new Main();
        System.out.println(main.getWord());
        System.out.println(main.getWord());
        System.out.println(main.getWord());
    }

    public Main(){
        BufferedReader reader; // replace with your ASCIIDataFile

        try {

            // additionally update this with your ASCIIDataFile as needed
            reader = new BufferedReader(new FileReader("your-file-here"));
            String read;

            while((read = reader.readLine()) != null) {
                sb.append(read);
                sb.append(","); // or whatever delimiter you want
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tokenizer = create();
    }

    public String getWord(){

        if (tokenizer.hasMoreTokens()) {
            return tokenizer.nextToken();
        }
        else{
            return null; // or throw an exception
        }
    }

    public void reset(){
        tokenizer = create();  // allows to interate through tokens again
    }

    private StringTokenizer create(){
        return new StringTokenizer(sb.toString(), ",");
    }
}