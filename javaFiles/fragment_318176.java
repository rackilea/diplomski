import java.util.Arrays;

class Example {

    // Private member variable
    private int[] data = { 1, 2, 3 };

    // Method that returns the private member variable
    public int[] getData() {
        return data;
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}

public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        // Prints: [1, 2, 3]
        example.showData();

        // Get the array
        int[] x = example.getData();

        // We can modify the array here!
        x[0] = 4;

        // Prints: [4, 2, 3]
        example.showData();
    }
}