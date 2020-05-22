try{
     someMethod();
}catch(InterruptedException e){
     //Restore interruption flag
     Thread.currentThread.interrupt();
     //If you have some clean up to do, do it here.
     return;
}