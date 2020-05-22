class A {
    public int get() { 
        return 10; 
    }
}

class B extends A {
    @Override 
    public int get() { 
        return 20; 
    }
}