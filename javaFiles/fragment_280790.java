public class TempThread extends Thread
{
    @Override
    public synchronized void start() {
        // TODO Auto-generated method stub
        super.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }

    // ******** Overload **********
    public synchronized void start(int i) {
        // TODO Auto-generated method stub
        super.start();
    }

    // ********* Overload **********
    public void run(int i) {
        // TODO Auto-generated method stub
        super.run();
    }

    public static void main(String[] args) 
    {
        TempThread t = new TempThread();
        t.start();
        t.run();
    }   
}