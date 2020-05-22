public void loadTableFromFile(String filepath) {
  Scanner s = null; // Our scanner.
  try {
    s = new Scanner(new BufferedReader(
        new FileReader(filepath))); // get it from the file.
    String line;
    while (s.hasNextLine()) { // while we have lines.
      line = s.nextLine(); // get a line.
      StringTokenizer st = new StringTokenizer(line, " ");
      int i = 0;
      while (st.hasMoreTokens()) {
        if (i != 0) {
          System.out.print(' '); // add a space between elements.
        }
        System.out.print(st.nextToken().trim()); // print the next element.
        i++;
        if (i % 10 == 0) { // Add a new line every ten elements.
          System.out.println();
        }
      }
      System.out.println(); // between lines.
    }
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } finally {
    if (s != null)
      s.close();
  }
}