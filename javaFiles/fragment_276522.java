class ShellScriptProcess implements Runneable() {

  private Process process;
  public ShellScriptProcess(Process process) {
     this.process=process;
  }

  boolean synchronized finished = false;
  public void run() {
    process.waitFor(); //this will wait until the process terminates
    finished = true;
  }
  public boolean isFinished(){
    return finished;
 }
}