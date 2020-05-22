import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestSocialGraph {
    public static void main(String args[]) {
        int[][] edges;
        File input = new File("GraphInput.txt");
        try {
            Scanner reader = new Scanner(input);
            reader.nextLine();// Skips the first line (nameList)
            int count = 0;
            // Count the total number of 2 element arrays
            while (reader.hasNextLine()) {
                String passer = reader.nextLine();
                count += passer.split(" ").length - 1;
            }
            reader.close();

            edges = new int[count][];
            int i = 0;
            reader = new Scanner(input);
            reader.nextLine();// Skips the first line (nameList)
            while (reader.hasNextLine()) {
                String passer = reader.nextLine();
                String[] split = passer.split(" ");
                for (int j = 1; j < split.length; j++) {
                    edges[i + j - 1] = new int[2];
                    edges[i + j - 1][0] = Integer.parseInt(split[0]);
                    edges[i + j - 1][1] = Integer.parseInt(split[j]);
                }
                i += split.length - 1;
            }
            reader.close();
            print(edges);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void print(int[][] e) {
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++)
                System.out.print(e[i][j] + " ");
            System.out.println();
        }
    }
}