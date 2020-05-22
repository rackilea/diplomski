public void display() {
      Node current = first;
      while(current != null) {
          System.out.println((current.data));
          current = current.next;
      }
 }