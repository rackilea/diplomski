public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    reverseQueue(q);
  }

  public static void reverseQueue(Queue<Integer> queue) {
    Stack<Integer> stack = new Stack<Integer>();
    while (!queue.isEmpty()) {
        stack.push(queue.remove());
    }
    while (!stack.isEmpty()) {
        queue.add(stack.pop());
    }
    System.out.println(queue);
  }