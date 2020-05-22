public static void replace(String oldstring, String newstring, File in, File out)
throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(in));
    PrintWriter writer = new PrintWriter(new FileWriter(out));
    String line = null;
    while ((line = reader.readLine()) != null)
        writer.println(line.replaceAll("(?i)" + oldstring,newstring));
    reader.close();
    writer.close();
}