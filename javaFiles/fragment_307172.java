public void executeScript() {
  try {
    ProcessBuilder pb = new ProcessBuilder(
      "myscript.sh");
    Process p = pb.start();     // Start the process.
    p.waitFor();                // Wait for the process to finish.
    System.out.println("Script executed successfully");
  } catch (Exception e) {
    e.printStackTrace();
  }
}