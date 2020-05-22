class A {
    int i = 10;
}

class B extends A {
    int i = 20;

    @Override 
    public String toString() { 
        return String.format("super: %d; this: %d", super.i, this.i);
    }
}