import java.util.*;
public class SlegProgram {

    private static int key;

    public static void main(String [] args)  {

        // Create some Slegs

        List<Sleg> slegs = Arrays.asList(new Sleg(1,2,500), new Sleg(2,5,400), new Sleg(1,2,500), new Sleg(2,5,400));

        System.out.println(slegs);

        // Create a Sleg Map with keys

        Map <Integer, Sleg> slegMap = new HashMap<>();

        for (Sleg sleg : slegs) {
            slegMap.put(++key, sleg);
        }

        System.out.println(slegMap);

        // Instantiate and printout u [key][G]

        for (Map.Entry<Integer, Sleg> entry : slegMap.entrySet()) {

            int [][] u = new int [entry.getKey()][Model.G];
            System.out.println(Arrays.deepToString(u)); // prints array with initial values: 0
            assignValuesToU(u);
        }

        // Assert i != j in each Sleg

        Sleg illegal = new Sleg(1, 1, 90); // This will throw an exception as i and j are equal
    }

    private static void assignValuesToU(int [][] u) {

        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u[i].length; j++) {
                u [i][j] = 80; // 80 or whatever it needs to be
            }
        }
        System.out.println(Arrays.deepToString(u)); // prints array with assigned values
    }
}

class Sleg {
    private int i;
    private int j;
    private int k;
    public Sleg(int i, int j, int k) {
        if (i == j) {
            throw new IllegalArgumentException("Invalid sleg parameters: " + Integer.toString(i));
        }
        this.i = i;
        this.j = j;
        this.k = k;
    }
    public String toString() {
        return Integer.toString(i) + "-" + Integer.toString(j) + "-" + Integer.toString(k);
    }
}

class Model {
    public static final int Y = 7;
    public static final int K = 42;
    public static final int G = 3;
}