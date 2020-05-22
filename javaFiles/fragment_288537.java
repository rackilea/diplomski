public static void main(String[] args) {
  String filename = args[1].substring(0, args[1].length() - 5);
  String cmd1 = "javac " + args[1];
  String cmd2 = "java " + filename;

  try {
    // Use a ProcessBuilder
    ProcessBuilder pb = new ProcessBuilder(cmd1);

    Process p = pb.start();
    InputStream is = p.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    int r = p.waitFor(); // Let the process finish.
    if (r == 0) { // No error
       // run cmd2.
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
}