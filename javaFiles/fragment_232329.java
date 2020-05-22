private final BlockingQueue<Boolean> queue = new LinkedBlockingQueue<>(1024);

while (true) {
    .....
    //check whether value has changed and do
    queue.put(true);
    .....
}

....
....

new Thread(new Runnable() {
    @Override
    public void run() {
        while(queue.take()){
           yes();
        }
    }
}).start();