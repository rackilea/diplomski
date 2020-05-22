public String[] ReadScanlist(String fileIn) {
    String directory = "c:\\data\\";
    String h5Files[];
    File fileToRead = new File(directory + fileIn);
    try {   
        int i = 0;
        do {
            FileReader fr = new FileReader(fileToRead);
            LineNumberReader lineToRead = new LineNumberReader(fr);
            int linereader = 0;
            while (lineToRead.readLine() != null) {
                linereader++;
            }

            linereader = 0;
            lineToRead.setLineNumber(0);
            h5Files = new String[linereader];
            while (lineToRead.readLine() != null) {
                h5Files[linereader] = lineToRead.readLine();                    
                linereader++;
            }
            return h5Files;
        } while (i != -1);
    } catch (IOException exc) {
        System.out.println("Error reading file.");
    }
    return h5Files;
}