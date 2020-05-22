import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Loading {

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(
                    "DB.xml"));
            String line, txt = "";
            List<String> lines = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            System.out.println(txt);
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("file2"));
            for(int i=lines.size()-1; i>=0; i--){
            bw.write(lines.get(i));
            bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}