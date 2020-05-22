public class MyTimerTask extends TimerTask  {
    Timer owner = null; 
    public MyTimerTask(Timer timer) {this.owner = timer;}
    @Override
    public void run() {
        try {
            throw new IOException("file not found");
        } catch (IOException e) {
            owner.cancel();
            throw new IOExceptionUnchecked(e);
        }
    }
}