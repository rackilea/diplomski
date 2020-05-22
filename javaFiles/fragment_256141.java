import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws Exception {

        File file = new File("./src/city.csv");
        Scanner scan = new Scanner(file);

        BufferedReader in = new BufferedReader(new FileReader("./src/city.csv"));
        Pattern p = Pattern.compile("\\w+");
        for (String temp = ""; temp != null; temp = in.readLine()) {
            String[] cities = temp.split(",");
            if (cities.length == 1)
                System.out.println(cities[0]);
            if (cities.length > 1)
                System.out.println(cities[0] + " -->" + cities[1]);
        }
        in.close();

    }
}