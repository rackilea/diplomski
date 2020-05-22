import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.Files;

public class LinesDeleter {
    private static boolean between;

    public static void main(String[] args) throws IOException {

        File file = new File("somePath");
        deleteLinesBetweenFromFile("line1", "line2", file);

    }

    private static void deleteLinesBetweenFromFile(String start, String end,
            File file) throws IOException {
        List<String> readLines = null;
        List<String> newLines = new ArrayList<String>();
        Charset charset = Charset.defaultCharset();

        readLines = Files.readLines(file, charset);

        if (readLines != null) {
            for (String line : readLines)
                if ( !isBetweenBannedLines(line, start, end))
                    newLines.add(line);
            File to = new File("somefile");
            Files.write(writeAsSingleLines(newLines), to, charset);
        }

    }

    private static CharSequence writeAsSingleLines(List<String> newLines) {
        // TODO Auto-generated method stub
        return null;
    }

    private static boolean isBetweenBannedLines(String line, String start,
            String end) {
        if (line.equals(start)) {
            between = true;
            return true;
        }
        if (line.equals(end)) {
            between = false;
            return true;
        }
        if (between)
            return true;
        return false;
    }

}