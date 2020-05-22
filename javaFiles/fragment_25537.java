LinkedStack<Integer> stack = new LinkedStack<>();
  stack.push( 5 );
  stack.push( 4 );
  stack.push( 3 );
  executeMultiplication( stack );
  executeSum( stack );
  int result = stack.pop();