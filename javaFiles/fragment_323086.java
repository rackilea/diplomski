class RuntimeExec {
  public static void main(String[] args) {
      try {
        // Execute a command as a single line
        File f = new File("C:/Users/Axel Richter/Documents/The Template.dotx");
        System.out.println(f.getAbsolutePath());
        String cmd = "cmd /C start \"\" \"" + f.getAbsolutePath() + "\"";
        Process child = Runtime.getRuntime().exec(cmd);

        InputStream in = child.getErrorStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
        in.close();

      } catch (IOException e) {
        e.printStackTrace();
      }

  }
}

class UseProcessBuilder {
  public static void main(String[] args) {
      try {
        //use ProcessBuilder to have more control
        File f = new File("C:/Users/Axel Richter/Documents/The Template.dotx");
        System.out.println(f.getAbsolutePath());
        String file = f.getAbsolutePath(); 
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "start", "\"\"", file);
        Process process = pb.start();

        InputStream in = process.getErrorStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
        in.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}