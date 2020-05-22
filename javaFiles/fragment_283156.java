public class Extract {
    public static void main (String[] args) throws java.lang.Exception {

        final File inputFile = new File("myFile.txt");
        final File tempFile = new File("myTempFile.txt");

        try(
            final BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            final BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        ) {

            final String lineToRemove1 = "00:1a:1e:87:04:d0";
            final String lineToRemove2 = "00:1a:1e:85:a4:00";
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                final String trimmedLine = currentLine.trim();
                if (!currentLine.contains(lineToRemove1) 
                        && !currentLine.contains(lineToRemove2)) {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
        } finally {
            if (reader != null) { 
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}