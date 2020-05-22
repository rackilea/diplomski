Queue queue = new LinkedBlockingQueue(...)
...
while(true){
        Data data = queue.take(); // this will wait until there's data in the queue
        doStuff(data);
}