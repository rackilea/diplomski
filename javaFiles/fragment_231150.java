import java.util.StringTokenizer;

public class ThirteenthMain {

    public static void main(String[] args) {

        String text = "Bear Car Bear Cat Car Dog Bear";
        StringTokenizer str = new StringTokenizer(text);
        String word[] = new String[10];
        String unique[] = new String[10];
        // reading the words to analyze
        int wordSize = 0;
        while (str.hasMoreTokens()) {
            String w = str.nextToken();
            word[wordSize] = w;
            System.out.println(wordSize + ": " + word[wordSize]);
            wordSize++;
        }
        System.out.println("---Frequency---");
        // create unique words
        int uniqueWordSize = 0;
        for (int i = 0; i < wordSize; i++) {
            boolean found = false;
            for (int j = 0; j < uniqueWordSize; j++) {
                if (word[i].equals(unique[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[uniqueWordSize++] = word[i];
            }
        }
        // measuring frequency
        int[] measure = new int[10];
        for (int i = 0; i < uniqueWordSize; i++) {
            for (int j = 0; j < wordSize; j++) {
                if (unique[i].equals(word[j])) {
                    measure[i]++;
                }
            }
        }
        //printing results
        for (int i = 0; i < uniqueWordSize; i++) {
            System.out.println(unique[i] + " : " + measure[i]);
        }
    }
}