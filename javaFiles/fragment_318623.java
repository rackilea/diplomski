import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        try {
            for (String line : searchWord("land")) {
                System.out.println(line);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static List<String> searchWord(String key) throws Exception {

        LineNumberReader lnr = new LineNumberReader(new FileReader(new File("StuffToRead.txt")));

        return recursiveSearch(lnr.readLine(), key, lnr);
    }

    public static List<String> recursiveSearch(String currentLineText, String key, LineNumberReader lnr)
                    throws Exception {

        List<String> results = new ArrayList<String>(25);
        if (currentLineText != null) {
            String lCase = currentLineText.toLowerCase();
            if (lCase.contains(key.toLowerCase())) {

                results.add("Line " + lnr.getLineNumber() + ": " + currentLineText);
            }
            results.addAll(recursiveSearch(lnr.readLine(), key, lnr));
        }
        return results;
    }

}