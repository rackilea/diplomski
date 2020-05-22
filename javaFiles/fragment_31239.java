public class Processor implements Runnable {
    static public class InputItem {
        final ResponseOutput client;
        final String command;

        public InputItem(ResponseOutput client, String command) {
            this.client = client;
            this.command = command;
        }
    }

    static private Processor instance;
    static public void queue(InputItem item) {
        instance.commandQueue.add(item);
    }

    private BlockingQueue<InputItem> commandQueue;

    public void run() {
        try {
            while (true) {
                InputItem item = commandQueue.take();
                String reply = doStuff(item.command);
                item.client.sendReply(reply);
            }
        } catch (InterruptedException ie) {
            ... error handling ....
        }
    }
}