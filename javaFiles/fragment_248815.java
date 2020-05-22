StackArray stack = new StackArray();
    stack.push(0, 0);
    stack.push(1, 10);
    System.out.println(stack.pop(0));
    stack.push(1, 20);
    System.out.println(stack.pop(1));
    System.out.println(stack.pop(1));