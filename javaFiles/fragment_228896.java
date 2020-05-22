import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToCapitalUsingStreams {
    // collection holds all the words that are not to be capitalized
    private static final List<String> EXCLUSION_LIST = Arrays.asList(new String[]{"or"});

    public String convertToInitCase(final String data) {
        String[] words = data.split("\\s+");
        List<String> initUpperWords = Arrays.stream(words).map(word -> {
            //first make it lowercase
            return word.toLowerCase();
        }).map(word -> {
            //if word present in EXCLUSION_LIST return the words as is
            if (EXCLUSION_LIST.contains(word)) {
                return word;
            }

            //if the word not present in EXCLUSION_LIST, Change the case of
            //first letter of the word and return
            return Character.toUpperCase(word.charAt(0)) + word.substring(1);
        }).collect(Collectors.toList());

        // convert back the list of words into a single string
        String finalWord = String.join(" ", initUpperWords);

       return finalWord;
    }

    public static void main(String[] a) {
        System.out.println(new ConvertToCapitalUsingStreams().convertToInitCase("Taxi or bus driver"));

    }
}