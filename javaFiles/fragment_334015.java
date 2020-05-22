public void outputData(String outputFile) {

            try {

        // Create file
        FileWriter fileStream = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileStream);

        writer.write(readFile(THE MP3 FILE DIRECTORY));

        // Close writer
        writer.close();

        // Handle exceptions
    } catch (Exception e) {
        e.printStackTrace();
    }
}