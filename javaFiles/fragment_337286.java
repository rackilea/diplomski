private synchronized void addData(int data) {
    while(queue.size()>=10) wait(); //wait() will temporarily release lock
    queue.add(data);
    notifyAll();
}

private synchronized int takeData() {
    while(queue.size()<=0) wait(); //wait() will temporarily release lock
    int poll = queue.poll();
    notifyAll();
    return poll;
}