public void pop() {
    int popped = 0;
    while(!q1.isEmpty()) {

      popped = q1.poll ();
      if (!q1.isEmpty ()) {
        q2.add (popped);
      }
    }

    size--;
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;

    System.out.println("Popped "+popped);
}