static void append(Queue<Integer> fifo, int i) {
  if (!fifo.offer(i)) {
      fifo.poll();
      fifo.offer(i);
  }
}

// in main:
Queue<Integer> fifo3 = new ArrayBlockingQueue<>(2);
append(fifo3, 1);
append(fifo3, 2);
append(fifo3, 3);
System.out.println(fifo3); // prints [2, 3]