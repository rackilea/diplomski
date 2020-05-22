import java.io.*;
import java.util.*;

public class nodes {

    private static HashMap<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) {
        File file = new File("nodes.txt");
        Scanner scnr = null;
        try {
            scnr = new Scanner(file);
        } catch (FileNotFoundException e) {

        }
        while(scnr.hasNext()) {
            String line = scnr.nextLine();
            String[] getId = line.split("\\s+");
            int id = Integer.parseInt(getId[0]);
            int count = 0;
            int copy = 0;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '|')
                    count++;
                if(count == 3) {
                    copy = i;
                    break;
                }
            }
            String parent = line.substring(copy + 1);
            map.put(id, parent);
            System.out.println(map);
        }
    }

}