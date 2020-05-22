import java.util.ArrayList;
import java.util.List;

public class Shortcut {

    public Shortcut() {
        printMultipleWordShortcuts("Contrast Agents");
    }

    private String[] getSingleWordShortcuts(String input) {

        String[] possibleCombinations = new String[ input.length() ];

        // Iterate backwards over the input string and get possible
        // combinations
        for(int i = input.length(); i > 0; i--) {

            possibleCombinations[i-1] = input.substring(0, i);

        }

        return possibleCombinations;

    }

    private void printMultipleWordShortcuts(String input) {

        // Split the input string, assuming that the input words are separated by spaces
        String[] splitWords = input.split(" ");

        List<String[]> allCombinations = new ArrayList<>();

        List<String> result = new ArrayList<>();

        // Get possible combinations for every split word.
        for(int i = 0; i < splitWords.length; i++) {
            allCombinations.add(getSingleWordShortcuts(splitWords[i]));
        }

        for(int i = 0; i < allCombinations.size(); i++) {

            for(int j = allCombinations.get(i).length; j > 0; j--) {

                if(i + 1 < allCombinations.size()) {

                    for(int c = 0; c<allCombinations.get(i+1).length; c++) {

                        result.add(allCombinations.get(i)[j-1] + ". " + allCombinations.get(i+1)[c] + ".");
                    }
                }
            }
        }

        // Output all possibilities
        for(String s : result) {
            System.out.println(s);
        }
    }
}