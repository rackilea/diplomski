public class ProcMon implements Runnable {

  private final Process _proc;
  private volatile boolean _complete;

  public boolean isComplete() { return _complete; }

  public void run() {
    _proc.waitFor();
    _complete = true;
  }

  public static ProcMon create(Process proc) {
    ProcMon procMon = new ProcMon(proc);
    Thread t = new Thread(procMon);
    t.start();
    return procMon;
  }
}