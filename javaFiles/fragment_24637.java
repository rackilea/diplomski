public void Adauga(String text) {
    java.util.Date date = new java.util.Date();
    Timestamp ts = new Timestamp(date.getTime());
    BufferedWriter bufferWritter = null;
    try {
        File file = new File("test.txt");
        FileWriter fileWritter = new FileWriter(file, true);
        bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("Hello: " + " --- " + ts + "\r\n");
        bufferWritter.close();
    } catch (IOException exception) {
        System.err.println("Save oops");
    } finally {
        if (bufferWritter != null) {
            try {
                bufferWritter.close();
            } catch (IOException exception) {
                System.err.println("Error closing writer");
                exception.printStackTrace();
            }
        }
    }
}