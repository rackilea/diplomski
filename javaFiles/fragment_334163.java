import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static final int SIZE = 100;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("C:\\Users\\Nick\\Desktop\\coords.txt"));
        int x = 0;
        int y = 0;
        int[] xCoords = new int[SIZE];
        int[] yCoords = new int[SIZE];
        int index = 0;
        while (s.hasNextLine()) {
            if (s.hasNextInt()) {
                x = s.nextInt();
            } else {
                System.out.println("had a next line, but no integers to read");
                break;
            }
            if (s.hasNextInt()) {
                y = s.nextInt();
            } else {
                System.out.println("had a next line, but no integers to read");
                break;
            }
            xCoords[index] = x;
            yCoords[index] = y;
            index++;
        }
        System.out.println("Output from what was read in from file:");
        for (int i = 0; i < index; ++i) {
            System.out.print(xCoords[i] + ", ");
            System.out.println(yCoords[i]);
        }
        s.close();
        char[][] graph = new char[21][42];
        for (int i = 0; i < graph.length; ++i)
            for (int j = 0; j < graph[0].length; ++j)
                graph[i][j] = ' ';
        for (int i = 0; i < graph.length; ++i)
            graph[i][0] = '/';
        graph[20][0] = '+';
        for (int i = 1; i < graph[0].length; ++i)
            graph[20][i] = '-';
        for (int i = 0; i < index; ++i)
            graph[21 - 1 - yCoords[i]][xCoords[i] + 1] = 'X';
        for (int i = 0; i < graph.length; ++i) {
            for (int j = 0; j < graph[0].length; ++j)
                System.out.print(graph[i][j]);
            System.out.println();
        }
    }
}