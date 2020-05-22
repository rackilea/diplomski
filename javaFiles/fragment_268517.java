import java.util.*;

public class Test {
    public static void main(String[] args) {
    String line = "The dog is in the house";
    line = line.replace(" ", "");
    List<String> list = new ArrayList<String>();
    for (int i = 0; i <= line.length() - 4; i++) 
        list.add(line.substring(i, i + 4));
    System.out.println(list);