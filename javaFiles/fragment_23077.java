import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadingTest {
    public static void main(String[] args) throws IOException, ParseException {
        // Import file to java
        File file = new File("table.csv");

        // Read the file
        Scanner infile = new Scanner(file);

        // Skip the first line in table.csv
        infile.nextLine();

        // Define format of date
        SimpleDateFormat hammerFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat slashFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Name the variables user enters
        Date start = hammerFormat.parse(args[0]);
        Date end = hammerFormat.parse(args[1]);

        // Create ArrayList for each column of data
        ArrayList < String > date = new ArrayList < String > ();
        ArrayList < Double > open = new ArrayList < Double > ();
        ArrayList < Double > high = new ArrayList < Double > ();
        ArrayList < Double > low = new ArrayList < Double > ();
        ArrayList < Double > close = new ArrayList < Double > ();

        while (infile.hasNext()) {
            // Tokenize columns by comma
            String[] data = infile.nextLine().split(",");
            // Organize each column of data to one index of data array
            date.add(data[0]);
            open.add(Double.parseDouble(data[1]));
            high.add(Double.parseDouble(data[2]));
            low.add(Double.parseDouble(data[3]));
            close.add(Double.parseDouble(data[4]));
        }
        // Show options and ask user to choose
        System.out.println("1. Hammer");
        System.out.println("2. Three white soldiers");
        System.out.println("3. Bullish kicker");

        // Record user input and execute corresponding code
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1)
            for (int i = 0; i < date.size(); i++)
                if (close.get(i) > open.get(i) && close.get(i) > ((high.get(i)) + (low.get(i))) / 2 && ((close.get(i) - low.get(i)) / 2 > (high.get(i) - close.get(i))))
                    System.out.println("Pattern found: " + hammerFormat.format(slashFormat.parse(date.get(i))));
    }
}