public class Laj {

  private static class ReadingThread extends Thread {
    private final InputStream inputStream;
    private final String name;

    public ReadingThread(InputStream inputStream, String name) {
      this.inputStream = inputStream;
      this.name = name;
    }

    public void run() {
      try {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(inputStream));
        for (String s = in.readLine(); s != null; s = in.readLine()) {
          System.console().writer().println(name + ": " + s);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    String command = "psql -U archadm arch";
    final Process child = Runtime.getRuntime().exec(command);
    new ReadingThread(child.getInputStream(), "out").start();
    new ReadingThread(child.getErrorStream(), "err").start();
    BufferedWriter out = new BufferedWriter(
        new OutputStreamWriter(child.getOutputStream()));
    out.write("\\h");
    out.newLine();
    out.flush();
    out.write("\\q");
    out.newLine();
    out.flush();
  }

}