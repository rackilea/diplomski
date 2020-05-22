public static void replaceSelected(File file, String type) throws IOException {

    // we need to store all the lines
    List<String> lines = new ArrayList<String>();

    // first, read the file and store the changes
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line = in.readLine();
    while (line != null) {
        if (line.startsWith(type)) {
            String sValue = line.substring(line.indexOf('=')+1).trim();
            int nValue = Integer.parseInt(sValue);
            line = type + " = " + (nValue+1);
        }
        lines.add(line);
        line = in.readLine();
    }
    in.close();

    // now, write the file again with the changes
    PrintWriter out = new PrintWriter(file);
    for (String l : lines)
        out.println(l);
    out.close();

}