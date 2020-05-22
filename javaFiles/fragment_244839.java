public static String[][] LibToArray() {
    List<String[]> lines = new ArrayList<>();
    String delimiter=",";  
    try (BufferedReader br= new BufferedReader(new FileReader("hexlibrary.txt"))) {
        String line = br.readLine();
        while (line != null) {
            String[] tmp = line.split(delimiter);
            // the next line is dangerous--what if there was only one token?
            // should add a check that there were at least 2 elements.
            lines.add(new String[] {tmp[0], tmp[1]});
            line = br.readLine();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "File not found.  Check name and directory.");
    }
    String[][] hexLibrary = new String[lines.length][];
    lines.toArray(hexLibrary);
    return hexLibrary;
}