import java.io.*;

class RuntimeExec {
  public static void main(String[] args) {
      try {
        // Execute a command as a single line
        File f = new File("C:/Users/axel/Documents/The Template.dotx");
        System.out.println(f.getAbsolutePath());
        String cmd = "cmd /C start winword.exe /t\"" + f.getAbsolutePath() + "\"";
        Process child = Runtime.getRuntime().exec(cmd);

      } catch (IOException e) {
        e.printStackTrace();
      }

  }
}

class UseProcessBuilder {
  public static void main(String[] args) {
      try {
        //use ProcessBuilder to have more control
        File f = new File("C:/Users/axel/Documents/The Template.dotx");
        System.out.println(f.getAbsolutePath());
        String application = "winword.exe";
        String switchNewFromTemplate = "/t";
        String file = f.getAbsolutePath(); 
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "start", application, switchNewFromTemplate+file);
        Process process = pb.start();

      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}