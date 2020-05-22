File customerFile = new File("Accounts.txt");
ArrayList<String> accountsList = new ArrayList<>();
// Try With Resources...
try (Scanner input = new Scanner(customerFile)) {
    while (input.hasNextLine()) {
        String line = input.nextLine().trim(); // Trim each line as they are read.
        if (line.equals("")) { continue; }     // Make sure a data line is not blank.
        accountsList.add(line);                // Add the data line to Account List
    }
}
catch (FileNotFoundException ex) {
    ex.printStackTrace();
}