import java.io.BufferedReader;;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**
     * Use {@link StringBuilder} to convert a `Character` list to {@code String}.
     */
    public static String charactersToString(java.util.List<Character> chars)
    {
        StringBuilder sb = new StringBuilder(chars.size());
        for (Character c : chars) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    /**
     * Use {@link Stream} to convert {@code String} to a list of {@code chars}.
     */
    public static java.util.List<Character> stringToCharacters(String text) {
        return text.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        java.io.File file = new java.io.File("file.txt");
        java.util.List<String> content = new java.util.ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                /* Convert String to Character array so that
                 * it can be easily processed each char at a time
                 */
                java.util.List<Character> chars = stringToCharacters(line);
                /*
                 * Check if ascii value of char matches ESC
                 */
                chars.removeIf(c -> (int)c == 27);
                /*
                 * Add the processed line to a list that will later
                 * be used to write back to the same file
                 */
                content.add(charactersToString(chars));
            }
            /* 
             * Write all processed lines back to the same file
             */
            java.nio.file.Files.write(file.toPath(), content);
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}