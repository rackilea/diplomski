public void process(Message message) {

    Thread processingThread = new Thread(new Runnable() {           
        @Override
        public void run() {
            ... do something ...
            ... call other objects/methods etc...
            System.out.println("Sending message " + message.id);

        }
    });

    processingThread.start();

}