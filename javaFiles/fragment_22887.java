String prefix = "GeneralDetails|"; // Or whatever you want it to be
BufferedReader reader = new BufferedReader(new InputStreamReader(
    new FileInputStream("input.txt"), "UTF-8")); // Specify the charset here
try {
    int outputIndex = 0;
    BufferedWriter writer = null;
    try {
        String line;
        while ((line = reader.readLine() != null) {
            // Check whether we need to start a new file, closing the old one.
            if (writer == null || line.startsWith(prefix)) {
                if (writer != null) {
                    writer.close();
                }
                outputIndex++;
                string path = "Collateral " + outputIndex + ".txt";
                // Specify the output encoding here
                writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "UTF-8")); 
            }
            writer.write(line);
            writer.newLine();
        } else {
        }
    } finally {
        if (writer != null) {
            writer.close();
        }
    }
} finally {
    reader.close();
}