public class SenderThread extends Thread {
    private static Handler senderHandler;

    public void run(){
        Looper.prepare();

        LooperThread looperThread = new LooperThread();
        senderHandler = looperThread.getHandler(); // Should no longer error :-)

        //do stuff
        senderHandler.msg(obj);
        Looper.loop();
    }
}