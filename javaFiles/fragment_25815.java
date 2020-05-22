Con() {
    this(++x); //1

    // This is where initialization is done. You can't access x before it.
    x = 10;
    System.out.println("x :"+x);
}