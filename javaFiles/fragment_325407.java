public void main ()
{
    // direct way
    new Thread(new Runnable() { public void run() { dud(); } }).start();
    // indirect way
    Thread t = new Thread(new Runnable() { public void run () { dud(); } });
    t.start();
}