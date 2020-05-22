import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        caluclateFinalList();
    }

    private static void caluclateFinalList() {
        List<Integer> bookingList = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 5, 5));
        List<Integer> bookedList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 3, 4));

        // Output list
        List<Integer> finalList = new ArrayList<>(bookingList.size());

        // Loop
        for (int position = 0; position < bookedList.size(); position++) {
            // Calculate result
            int result = bookingList.get(position) - bookedList.get(position);
            // Add result to final list
            finalList.add(result);
        }

        // Print final list to the console
        System.out.println(finalList);
    }
}