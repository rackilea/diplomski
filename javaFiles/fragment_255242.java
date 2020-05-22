BlockingQueue queue = new LinkedBlockingQueue(2);
for ( int i=0; i< 10; i++){
    // Try to add the object and return immediately if it is full
    // then if it could not be added,
    // remove the last element of the queue and try again
    while (!queue.offer(i, 0L, TimeUnit.MICROSECONDS)) {
        queue.remove();
    }
    for ( Iterator it = queue.iterator(); it.hasNext();){
        System.out.println(it.next());
    }
    System.out.println("________");
}