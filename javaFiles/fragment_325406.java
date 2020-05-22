public void main ()
{
    // direct way
    new Thread(() -> dud()).start();
    // indirect way
    Thread t = new Thread(() -> dud());
    t.start();
}