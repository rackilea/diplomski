import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


class jsonToYaml
{
    public static void main(String args[]) throws Exception
    {
        String line, allLine;
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("config.yml")); // Add config.yml into the BufferedReader
        try
        {
            while ((line = bufferedReader.readLine()) != null) // Read line per line config.yml (from the BufferedReader) until it is over
            {
                stringBuilder.append(line); // add the line into stringBuilder
                stringBuilder.append(System.lineSeparator()); // add a lineSeparator into stringBuilder
            }
            allLine = stringBuilder.toString(); // allLine is equal to stringBuilder
        }
        finally
        {
            bufferedReader.close(); // Close the BufferedReader
        }

        String studioName = System.getProperty("user.name"); // set studioName

        FileWriter fileWriter = new FileWriter("/var/iprotecs/idns2.0/" + studioName + ".yaml", true); // create a FileWriter && true for append a String into  your FileWriter or false for ecrase a String into your FileWriter
        try
        {
            fileWriter.write(allLine ,0, allLine.length()); // Write allLine into "/var/iprotecs/idns2.0/ + studioName + .yaml"
        }
        finally
        {
            fileWriter.close(); // close the FileWriter
        }
    }
}