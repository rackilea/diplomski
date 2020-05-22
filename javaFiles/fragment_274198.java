public static void readCsvToConsole(String csvFilePath, String csvDelimiter) {
    String line;                            // To hold each valid data line.
    String[] columnNames = new String[0];   // To hold Header names.
    int dataLineCount = 0;                  // Count the file lines.
    StringBuilder sb = new StringBuilder(); // Used to build the output String.
    String ls = System.lineSeparator();     // Use System Line Seperator for output.

    // 'Try With Resources' to auto-close the reader
    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
        while ((line = br.readLine()) != null) {
            // Skip Blank Lines (if any).
            if (line.trim().equals("")) {
                continue;
            }
            dataLineCount++;
            // Deal with the Header Line. Line 1 in most CSV files is the Header Line.
            if (dataLineCount == 1) {
                /* The Regular Expression used in the String#split()
                   method handles any delimiter/spacing situation.*/
                columnNames = line.split("\\s{0,}" + csvDelimiter + "\\s{0,}");
                continue;   // Don't process this line anymore. Continue loop.
            }
            // Split the file data line into its respective columnar slot.
            String[] lineParts = line.split("\\s{0,}" + csvDelimiter + "\\s{0,}");
            /* Iterate through the Column Names and buld a String
               using the column names and its' respective data along
               with a line break after each Column/Data line.     */
            for (int i = 0; i < columnNames.length; i++) {
                sb.append(columnNames[i]).append(": ").append(lineParts[i]).append(ls);
            }
            // Display the data record in Console.
            System.out.println(sb.toString());  
            /* Clear the StringBuilder object to prepare for 
               a new string creation.     */
            sb.delete(0, sb.capacity());        
        }
    }
    // Trap these Exceptions
    catch (FileNotFoundException ex) {
        System.err.println(ex.getMessage());
    }
    catch (IOException ex) {
        System.err.println(ex.getMessage());
    }
}