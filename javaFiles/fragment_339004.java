ArrayList<String>  headerLines = new ArrayList();
BufferedReader br = new BufferedReader(new FileReader(file));
try {
    String line;
    int lineCount = 0;
    while ((line = br.readLine()) != null) {
       // process the line.
       if(lineCount % 7 == 0) {
           heaaderLines.add(line);
       }
       lineCount ++;
    }
} catch (IOException ioEx) {
    ioEx.printStackTrace();
} finally {
    br.close();
}