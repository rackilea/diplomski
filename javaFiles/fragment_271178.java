FileReader reader = null;
File file = new File("file.txt");
if (file.canRead()) {
    try {
        // Open the file
        reader = new FileReader(file);

        // ...read the file...

        // Close it
        reader.close();
        reader = null;
    }
    finally {
        if (reader != null) {
            // An exception occurred, close the reader but don't throw a new exception
            try {
                reader.close();
            }
            catch (Exception) {
            }
        }
    }
}