// Your outer loop
for (;;) {

  // Create some final declaration of `e`
  final E e = ...
  Callable<E> c = new Callable<E> {

    // You can have class variables
    private String x;

    // This is the only way to implement constructor logic in anonymous classes:
    {     
      // do something with e in the constructor
      x = e.toString();
    }  

    E call(){  
      if(e != null) return e;
      else {
        // long task here....
      }
    }
  }
}