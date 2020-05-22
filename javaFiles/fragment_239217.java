import java.io.*;
import java.util.*;
import java.util.stream.*;

public class MaxOccurence {

  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>();
    try {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "F:/Demo/file_reading/bin/demo/hello.txt")));
        String str;
        while ((str = br.readLine()) != null) {
            Scanner sc = new Scanner(str);
            while (sc.hasNext()) {
                String word = sc.next();
                if (map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }
        }
        System.out.println("yes");
    } catch (IOException e) {
        e.printStackTrace();
    }
    map.entrySet().stream()
              .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
              .forEachOrdered(System.out::println);

  }

}