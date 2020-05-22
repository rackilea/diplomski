void runInnerLoop( int start, int N, int depth, int maxDepth, Stack<Integer> stack) {    
  for (int x = start; x < N; x++ ) {
    stack.push( x ); //add the current value to the stack
    if( depth < maxDepth ) { //max depth not reached, do another recursion
      runInnerLoop( x + 1, N, depth + 1, maxDepth, stack );
    } else {
      System.out.println( stack ); //max depth reached, print now
    }
    stack.pop(); //remove the top value from the stack
  }  
}