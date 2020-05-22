class Example {
    private int myNumber;

    public Example() {
        myNumber = 42; // sets the field of the class
        int myNumber = 1337; // declares a new local variable shadowing the class field
        myNumber = -13; // accesses the object in the closest scope which is the local variable
        this.myNumber = 0; // explicitly accesses the class field
    }
}