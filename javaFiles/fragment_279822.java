// Try With Resources used here to auto-close BufferedReader.
try (
    BufferedReader br = new BufferedReader(new FileReader("DataFile.prn"))) {
    String line;
    StringBuilder sb;
    while ((line = br.readLine()) != null) {
        if (line.trim().equals("")) { continue; }
        sb = new StringBuilder();
        // Method called with supplied file data line and the widths of
        // each column as outlined within the file.
        String[] parts = splitStringToChunks(line, 16, 22, 9, 14, 13, 8);
        for (String str : parts) {
            sb.append(sb.toString().equals("") ? str : "; " + str);
        }
        System.out.println(sb.toString());
    }
}
catch (IOException ex) {
    System.out.println(ex.getMessage());
}