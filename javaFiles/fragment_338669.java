public void EjecutaHilosLambdaSegundo(ArrayList<Computer> listapcs, MyRunnable myRunnable)
{
    for(Computer computer: listapcs)
    {
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }
}