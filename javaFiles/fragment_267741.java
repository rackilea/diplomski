import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<String> list = readFileByLine(new ArrayList<String>(), "/Users/hassan/Library/Containers/com.apple.TextEdit/Data/Desktop/file.text");
        for(String s : list){
            System.out.println(s);
        }
    }

    public static List<String> readFileByLine(ArrayList<String> list, String fileName){
        try{
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            reader.useDelimiter(",");
            while(reader.hasNext()){
              String s = reader.next();
              s= s.trim();
              s= s.replaceAll("," , "");
              list.add(s);
            }
            reader.close();
        }
        catch(FileNotFoundException e){ System.err.println("Error: " + e.getMessage());}

        return list;
    }
}