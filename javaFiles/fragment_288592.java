import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author SubOptimal
 */
public class Main {

    public static Comparator<String> getComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // split the lines to compare by whitespaces
                String[] columns1 = o1.split("\\s+");
                String[] columns2 = o2.split("\\s+");
                // compare first column
                if (columns1[0].compareTo(columns2[0]) != 0) {
                    return columns1[0].compareTo(columns2[0]);
                }
                // compare third column
                if (columns1[2].compareTo(columns2[2]) != 0) {
                    return columns1[2].compareTo(columns2[2]);
                }
                // both lines have equal
                return 0;
            }
        };
    }

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("input.csv");
        // read all lines into a list of String
        List<String> lines = Files.readAllLines(path, DEFAULT_CHARSET);
        // sort the list using your own comparator
        Collections.sort(lines, getComparator());
        // output the sorted list
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
}