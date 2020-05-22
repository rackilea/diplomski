import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String line = "First number 10, Second number 25, Third number 123 ";
        String numbersLine = line.replaceAll("[^0-9]+", " ");

        String[] strArray = numbersLine.split(" ");

        List<Integer> intArrayList = new ArrayList<>();

        for (String string : strArray) {
            if (!string.equals("")) {
                System.out.println(string);
                intArrayList.add(Integer.parseInt(string));
            }
        }

        // what I want to get:
        // int[0] array = 10;
        // int[1] array = 25;
        // int[2] array = 123;
    }
}