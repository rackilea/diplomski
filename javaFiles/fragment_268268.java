Scanner in = new Scanner(System.in);
System.out.println("Enter the record you would like to see: ");
int userChoice = in.nextInt();

// Try With Resources is used here to auto-close the reader.    
try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    String line;
    int counter = 0;
    // String[] myArray = {};
    while ((line = reader.readLine().trim()) != null) {
        if (line.equals("")) {
            continue;
        }
        counter++;
        if (counter == userChoice) {
            // myArray = line.split("\\s{0,},\\s{0,}");
            // System.out.println(Arrays.toString(myArray).replaceAll("[,\\[\\]]", ""));
            // If you want to use an Array then un-comment the 
            // 3 lines above and comment the line below.
            System.out.println(line.replace(", ", " "));
            break;
        }
    }
}
catch (FileNotFoundException ex) {
    System.err.println(ex.getMessage());
}
catch (IOException ex) {
    System.err.println(ex.getMessage());
}