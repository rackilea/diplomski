import java.util.Queue;
    import org.apache.commons.collections4.queue.CircularFifoQueue;

    Queue<Integer> fifo = new CircularFifoQueue<Integer>(2);
    fifo.add(1);
    fifo.add(2);
    fifo.add(3);
    System.out.println(fifo);

    // Observe the result: 
    // [2, 3]