public class Test {
  static byte[] bytes = new byte[10_000_000];
  static {
    for (int i = 0; i < bytes.length; i++) bytes[i] = (byte) (i%100+32);
  }
  public static void main(String[] args) throws Exception {
    writer(true);
    writer(false);
    stream(true);
    stream(false);
  }

  static void writer(boolean flush) throws IOException {
    Writer out = new FileWriter("output.txt");
    long a = System.currentTimeMillis();
    for (byte j : bytes) {
      out.write(j);
      if (flush) out.flush();
    }
    out.close();
    System.out.println("FileWriter with" + (flush? "":"out") + " flushing: " +
        (System.currentTimeMillis() - a));
  }
  static void stream(boolean flush) throws IOException {
    OutputStream out = new FileOutputStream("output.txt");
    long a = System.currentTimeMillis();
    for (byte j : bytes) {
      out.write(j);
      if (flush) out.flush();
    }
    out.close();
    System.out.println("FileOutputStream with" + (flush? "":"out") + " flushing: " +
        (System.currentTimeMillis() - a));
  }
}