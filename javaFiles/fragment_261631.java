CSVReader reader = null;
try {
    reader = new CSVReader(new FileReader(filepath), ',');
    // Code from the original try block, removed for brevity's sake
} catch (Exception ex) {
    ex.printStackTrace(); // Or some useful error handling
} finally { // closing the reader in the finally block
    if (reader != null) {
        reader.close();
    }
}