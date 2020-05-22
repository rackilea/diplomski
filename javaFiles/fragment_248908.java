import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter Number of Process: ");
    int p = 0;

    try {
        p = Integer.parseInt(br.readLine());
    } catch (NumberFormatException nfe) {
        System.err.println("Invalid Format!");
    }

    Pair[] arrival = new Pair[p];
    for (int i = 0; i < p; i++) {
        System.out.print("Arrival Time of Process #" + (i + 1) + ":");
        try {

            arrival[i] = new Pair(i + 1, Integer.parseInt(br.readLine()));
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    }
    Arrays.sort(arrival);
    for (int i = 0; i < arrival.length; i++) {
        System.out.println("P" + arrival[i].index + ": " + arrival[i].value);
    }
}

// a little change was made to the original code
public static class Pair implements Comparable<Pair> {

    public final int index;
    public final int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.valueOf(this.value).compareTo(other.value);
    }
}