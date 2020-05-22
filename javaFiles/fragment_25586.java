$ cat Tiles.java 
import java.io.*;
import java.util.*;

class MainApp {
    public static void main(final String[] args) {
        final String fileName = "Tiles.dat";
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            List<List<Integer>> map = new ArrayList<List<Integer>>();

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] items = line.split(" ");
                ArrayList<Integer> intItems = new ArrayList<Integer>();
                for (String item : items) {
                    int intItem = Integer.parseInt(item);
                    intItems.add(intItem);
                }

                map.add(intItems);
            }
            br.close();

            System.out.println("map: '" + String.valueOf(map) + "'.");
            for (List<Integer> intItems : map) {
                System.out.println("intItems: '" + String.valueOf(intItems) + "'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}