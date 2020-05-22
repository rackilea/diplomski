//Create your callback listener interface...
public interface MyThreadListener{
    public void threadFinished();
}

//This is the method that runs some functionality in a separate thread
public void executeTaskInSeparateThread(final MyThreadListener listener){
    new Thread(new Runnable() {

        @Override
        public void run() {
            // DO your long task here...

            //Notify when done before leaving run method...
            listener.threadFinished();
        }
    }).start();
}

//Use it like this
//Create the implementation of the listener you want (this is something like what you usually do for buttons or any other android listener)
MyThreadListener listener = new MyThreadListener() {

    @Override
    public void threadFinished() {
        //Do whatever you want when notified...
        //NOTE: This method will be called on a separated thread too, you cannot modify views...
    }
};
executeTaskInSeparateThread(listener);