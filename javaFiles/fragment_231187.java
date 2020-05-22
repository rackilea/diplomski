static String read( String path ) throws IOException {
  StringBuilder sb = new StringBuilder();
  try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    for (String line = br.readLine(); line != null; line = br.readLine()) {
      sb.append(line).append('\n');
    }
  }
  return sb.toString();
}