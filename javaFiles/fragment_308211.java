public Sandwich() {
    super();   // Compiler adds it if it is not explicitly added by programmer
    // All the instance variable initialization is moved here by the compiler.
    b = new Bread();
    c = new Cheese();
    l = new Lettuce();

    System.out.println("Sandwich()");
}