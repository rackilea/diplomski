public boolean writeToTXT(String text, String path)
{
    BufferedWriter output = null;
    try {
        File file = new File(path);
        output = new BufferedWriter(new FileWriter(file));
        output.write(text);
        output.flush();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }

    try(BufferedReader br = new BufferedReader(new FileReader(path))) {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    return sb.toString().equals(text); }
}