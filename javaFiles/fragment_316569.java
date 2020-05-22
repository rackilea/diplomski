class ARunnable implements Runnable{
@Override
public void run(){
    Log.d("Runnable", "A Inside Run - WAIT");
    try{
        synchronized(this){wait();}
    } catch (InterruptedException e) {}
    //Log.d("Runnable", "A Inside Run - CONTINUE");
}
}