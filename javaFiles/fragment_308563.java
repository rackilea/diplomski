import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharTask {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            File file = new File("inp.txt");
            FileInputStream ins =new FileInputStream(file);
            Scanner scanner  = new Scanner(ins);
            lines = new ArrayList<String>();
            while(scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }

            List<String> output = processInput(lines);
            for (int i=1;i<output.size(); i++) {
                System.out.println(output.get(i));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static List<String> processInput(List<String> lines){

        List<String> output = new ArrayList<String>();
        for (String line: lines) {
            output.add(getProcessLine(line));
        }

        return output;


    }

    private static String getProcessLine(String line) {
        if(line.length() == 0) {
            return null;
        }

        String output = "";
        char prev = line.charAt(0);
        int count = 1;
        for(int i=1;i<line.length();i++) {

         char c = line.charAt(i);
         if (c == prev) {
             count = count +1;
         }
         else {
             output = output + " "+count + " "+prev;
             prev = c;
             count = 1;
         }
        }
        output = output + " "+count+" "+prev; 

        return output;
    }


}