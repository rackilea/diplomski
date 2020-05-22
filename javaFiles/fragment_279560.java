public boolean add(E element){
     if (!(element instanceof MyClass))
          throw new IllegalArgumentException("Element is not an instance of MyClass");

    // rest of add code here
}