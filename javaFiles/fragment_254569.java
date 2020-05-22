while (!q.isEmpty()) {
    IntTree node = q.dequeue();  //pop off the top element
    theta.enqueue(value(node)); // put the element in the queue to be printed

    //enqueue the children
    IntTree left = left(node);
    if ( left != null ) {
        q.enqueue(left);
    }
    //...similar for right
  }