import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InputStream {

private static final String ASSISTANT = "assistant";
private static final String ASSOCIATE = "associate";
private static final String FULL = "full";

public static void main(String[] args) {
    FileInputStream filestream;
    BufferedReader reader;
    PrintWriter writer;
    String line;

    double totalAssistant = 0;
    double totalAssociate = 0;
    double totalFull = 0;

    try {
        filestream = new FileInputStream("salary.txt");
        reader = new BufferedReader(new InputStreamReader(filestream));
        writer = new PrintWriter("test.txt");

        List<String> assistantList = new ArrayList<String>();
        List<String> associateList = new ArrayList<String>();
        List<String> fullList = new ArrayList<String>();

        while ((line = reader.readLine()) != null) {

            String[] split = line.split(" ");

            // Value
            double value = Double.parseDouble(split[split.length - 1]);

            // Type
            String type = split[split.length - 2];

            if (ASSISTANT.equals(type)) {
                totalAssistant += value;
                assistantList.add(line);

            } else if (ASSOCIATE.equals(type)) {
                totalAssociate += value;
                associateList.add(line);

            } else if (FULL.equals(type)) {
                totalFull += value;
                fullList.add(line);
            }
        }

        writeInFileOutput(writer, totalAssistant, assistantList);
        writeInFileOutput(writer, totalAssociate, associateList);
        writeInFileOutput(writer, totalFull, fullList);

        reader.close();

        writer.close();
    } catch (IOException e) {
        System.out.println(e);

    } finally {
        reader = null;
        filestream = null;
        writer = null;
    }

}

private static void writeInFileOutput(PrintWriter writer, double total,
        List<String> listLines) {
    for (String assistant : listLines) {
        writer.append(assistant).append("\n");
    }

    writer.append("-------\n");
    writer.append("Total Salary: $").append(String.valueOf(total)).append("\n");
    writer.append("Average Salary: $")
            .append(String.valueOf(total / listLines.size())).append(" \n\n");
}

}