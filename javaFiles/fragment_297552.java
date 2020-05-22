import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JavaTextFileToString {


        public static void main(String[] args) throws Exception {
            File file = new File("C:/20180918.jrn");

            BufferedReader br=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=br.readLine())!=null){
                if(line.equals("Cash")) {
                    System.out.println(line);
                }

            }

            br.close();
        }
    }