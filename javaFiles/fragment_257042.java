Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println(new ArrayList<>(stack)); // prints 1, 2, 3


Deque<Integer> deque = new ArrayDeque<>();
deque.push(1);
deque.push(2);
deque.push(3);
System.out.println(new ArrayList<>(deque)); // prints 3, 2, 1