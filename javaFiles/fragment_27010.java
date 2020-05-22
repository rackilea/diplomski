public void writeToFile(String fileName) {

  // **** Note that pW must be declared before the try block
  PrintWriter pW = null;
  try {
     pW = new PrintWriter(new File(fileName));
     for (int x = 0; x < 25; x++) {
        for (int y = 0; y < 25; y++) {
           pW.write(puzzle[x][y]);
        }
        pW.println();
     }
  } catch (IOException e) {
     // System.err.println("error is: "+e.getMessage());
     e.printStackTrace();  // *** this is more informative ***
  } finally {
     if (pW != null) {
        pW.close(); // **** closing it flushes it and reclaims resources ****
     }
  }
}