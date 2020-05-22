import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateReplacer
{
    private static final Pattern DATE_MATCHER =
            Pattern.compile("(?:(?:19|20)[0-9]{2})([0-9]{2})([0-9]{2})");

    public static void main(String... args)
            throws Exception
    {
        // These are the paths to our input and output files
        Path input = Paths.get("input.dat");
        Path output = Paths.get("output.dat");

        // We need to get today's date in YYYYDDMM format, so we create a
        // DateFormatter for that. If it turns out that your date format is
        // actually YYYYMMDD, you can just use DateFormatter.BASIC_ISO_DATE
        // instead.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyddMM");
        String todaysDate = LocalDate.now().format(formatter);

        // Use try-with-resources to create a reader & writer
        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output)) {
            String line;

            // Read lines until there are no more lines
            while ((line = reader.readLine()) != null) {
                // Split them on the | character, notice that it needs to be
                // escaped because it is a regex metacharacter
                String[] columns = line.split("\\|");

                // Iterate over every column...
                for (int i = 0; i < columns.length; i++) {
                    // ... and if the value looks like a date ...
                    if (isDateLike(columns[i])) {
                        // ... overwrite with today's date.
                        columns[i] = todaysDate;
                    }
                }

                // Re-join the columns with the | character and write it out
                writer.write(String.join("|", columns));
                writer.newLine();
            }
        }
    }

    private static boolean isDateLike(String str)
    {
        // Avoid the regular expression if we can
        if (str.length() != 8) {
            return false;
        }

        Matcher matcher = DATE_MATCHER.matcher(str);
        if (matcher.matches()) {
            // If it turns out that your date format is actually YYYYMMDD
            // you will need to swap these two lines.
            int day = Integer.parseInt(matcher.group(1), 10);
            int month = Integer.parseInt(matcher.group(2), 10);

            // We don't need to validate year because we already know
            // it is between 1900 and 2099 inclusive
            return day >= 1 && day <= 31 && month >= 1 && month <= 12;
        }

        return false;
    }
}