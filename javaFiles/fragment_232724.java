PrintWriter pw = null;
if (appendToFile) {
  pw = new PrintWriter(new FileWriter(filename, true));
} else {
  pw = new PrintWriter(new FileWriter(filename));
}