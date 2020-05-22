class BroadCastThread extends Thread{
    LinkedBlockingQueue<SendFileTask> bcQueue = new LinkedBlockingQueue<>();
    @Override
    public void run() {
        while( true ){
            try {
                SendFileTask task = bcQueue.take();
                task.sendFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    void addTask(SendFileTask rt) throws InterruptedException{
        bcQueue.put(rt);
    }
}
interface SendFileTask{
    void sendFile() throws Exception;
}