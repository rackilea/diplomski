import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileStream {
    public static void main(String[] args) throws IOException {
        //cases that you picked from table
        List<String> cases = Arrays.asList("case1", "case9");

        //open stream to file, please change directory and filename
        Stream<String> lines = Files.lines(Paths.get("C:\\test_java", "filterfile.txt"));

        //loop through stream line by line, pick up those that match
        List<String> readCases = lines.filter(line -> containsAll(line, cases)).collect(Collectors.toList());

        lines.close();
        System.out.println(readCases);
    }

    //this is a simple method that performs String's contains() for each
    //case in the list. 
    public static boolean containsAll(String line, List<String> cases) {
        for (String s : cases) {
            if (line.contains(s)) {
                return true;
            }
        }
        return false;
    }
}