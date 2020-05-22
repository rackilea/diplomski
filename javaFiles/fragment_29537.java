public class RequestHandler {
  File file = new File("output.txt");

  public void copyToOutput(InputStream in) {
    Files.copy(in, new FileOutputStream(file));
  }
}