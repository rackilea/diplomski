import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
class white {
public static void main(String[] args) {

    String line = "";
    String username = "";
    ArrayList <String> userNames = new ArrayList <String>();

    try{
       FileReader fr = new FileReader("investments.txt");
       BufferedReader br = new BufferedReader(fr);

        while((line = br.readLine()) != null) {
            line.split("\\s+");
            userNames.add(line.split("\\s+")[0]);
            System.out.println(line.split("\\s+")[0]);
        }
        }

    catch(IOException e){
            System.out.println("File not found!");
    }       
}   
}