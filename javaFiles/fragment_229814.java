PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
queue.offer(1);
queue.offer(2);
queue.offer(3);
//...

Integer val = null;
while( (val = queue.poll()) != null) {
    System.out.println(val);
}