private static void readAndWrite(PrintWriter pw, String filename) throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line = br.readLine();
    while (line!=null) {
        pw.println(line);
        line =br.readLine();    
    }
    br.close();
}