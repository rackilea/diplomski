import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    public static void main(final String[] args) {
        // Input.
        final List<String> words = Arrays.asList(
            "Hello",
            "World",
            "World",
            "World",
            "Goodbye"
        );

        // Output.
        // Associative container: maps a word to its count.
        final HashMap<String, Integer> wordToCountMap = new HashMap<>();
        for (final String word : words) {
            // Lookup into the map for the existing word counter.
            // If the word counter has not been found (we have just met the word for the first time),
            // create a counter with initial value.
            Integer wordCounter = wordToCountMap.getOrDefault(word, 0);

            // In any case, increase the counter and update the map with it.
            ++wordCounter;
            wordToCountMap.put(word, wordCounter);
        }

        // Output.
        // Preparing the output.
        final ArrayList<Map.Entry<String, Integer>> highToLowCountEntries =
            new ArrayList<>(wordToCountMap.entrySet());
        // Sorting the collected entries by word count.
        Collections.sort(
            highToLowCountEntries,
            Comparator
                .comparing(AbstractMap.Entry<String, Integer>::getValue)
                .reversed()
        );

        System.out.printf("Entries: from high to low count: %s.%n", highToLowCountEntries);
    }
}