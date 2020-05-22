public class MyThread extends Thread {
    private Process subprocess;

    @Override
    public void run() {
        subprocess = Runtime.getRuntime().exec("myprocess.exe");
        try {
            subprocess.waitFor();
        }
        catch (InterruptedException e) {
            subprocess.destroy();
        }
        /*
            Some more statements
        */
    }
}