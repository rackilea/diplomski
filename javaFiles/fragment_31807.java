import java.util.*;
import java.io.*;

public class Test {
    public static void main(String args[]){
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\A.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()){
                    System.out.println(line);
                } else {
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}