// External resource(s).
BufferedReader in = null;
PrintWriter out = null;
try {

  URL url = new URL(
      "https://twitter.com/search?q=%23JENOSMROOKIESOPENFOLBACK&src=tren");

  // read text returned by server
  in = new BufferedReader(new InputStreamReader(
      url.openStream()));

  String line;
  // out = new PrintWriter(new FileWriter(
  // "htmlsourcecode.txt"));

  final String DATA_NAME = "data-name=\"";
  while ((line = in.readLine()) != null) {
    int pos1 = line.indexOf(DATA_NAME); // opening position.
    if (pos1 > -1) { // did we match?
      // Add the length of the string.
      pos1 += DATA_NAME.length();
      // find the closing quote.
      int pos2 = line.indexOf("\"", pos1 + 1);
      if (pos2 > -1) {
        String dataName = line.substring(pos1,
            pos2);
        System.out.println(dataName);
        // out.print(line);
      }
    }
  }
} catch (Exception e) {
  e.printStackTrace();
} finally {
  // Close external resource(s).
  if (in != null) {
    try {
      in.close();
    } catch (IOException e) {
    }
  }
  if (out != null) {
    out.close();
  }
}