import java.util.ArrayList;
import java.util.List;


public class PrintAllCombinations {

    public void printAllCombinations() {
        for (String combination : allCombinations(new String[] { "A", "B", "C" })) {
            System.out.println(combination);
        }
    }

    private List<String> allCombinations(final String[] values) {
        return allCombinationsRecursive(values, 0, values.length - 1);
    }

    private List<String> allCombinationsRecursive(String[] values, final int i, final int n) {
        List<String> result = new ArrayList<String>();
        if (i == n) {
            StringBuilder combinedString = new StringBuilder();
            for (String value : values) {
                combinedString.append(value);
            }
            result.add(combinedString.toString());
        }
        for (int j = i; j <= n; j++) {
            values = swap(values, i, j);
            result.addAll(allCombinationsRecursive(values, i + 1, n));
            values = swap(values, i, j); // backtrack
        }
        return result;
    }

    private String[] swap(final String[] values, final int i, final int j) {
        String tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
        return values;
    }

}