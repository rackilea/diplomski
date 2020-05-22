public static void main(String[] args) {
    Queue q = new Queue();
    q.enqueue(7);
    q.enqueue(8);
    q.enqueue(9);
    System.out.println(q.dequeue()); // 7 (ok)
    System.out.println(q.dequeue()); // 8 (ok)
    System.out.println(q.dequeue()); // 9 (ok)
    System.out.println(q.dequeue()); // 1 (bug)
    System.out.println(q.dequeue()); // 1 (bug)
    System.out.println(q.dequeue()); // 1 (bug)
  }