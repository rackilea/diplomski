import java.io.BufferedReader;
import java.io.FileReader;

public class MyProject {

    public static void main(String [] args){
      String path = "C:/temp/stack/scores.txt";
      processTextFile(path);    
    }

    public static void processTextFile(String filePath) {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            String [] tokens = null;
            int score = 0;
            int x = 0;
            int y = 0;
            int z = 0;

            while (line != null) {
                tokens = line.split(" ");
                score = Integer.parseInt(tokens[tokens.length -1]);

                if(score >= 0 && score < 20){
                    x++;
                }
                if(score >= 20 && score < 60){
                    y++;
                }
                if(score > 60){
                    z++;
                }

                line = br.readLine();
            }

            if (br != null) {
                br.close();
            }

            System.out.println("0-20 = " + x + ", 20-60 = " + y + ", 60+ = " + z);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}