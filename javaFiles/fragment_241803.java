public class ProcessSample {
 public static void main(String [] arg) throws Exception {
   ProcessBuilder pb =
      new ProcessBuilder("python", "script.py").inheritIO();
    Process p = pb.start();
    p.waitFor();
  }
}