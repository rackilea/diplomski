interface Foo extends Cloneable { public int getX(); public void setX(int x);  }
enum FooSingleton implements Foo { 
    INSTANCE; 
    private int x;
    public int getX(){ return x; }
    public void setX(int x){ this.x = x; }
}
class FooClass implements Foo { 
    private int x;
    public int getX(){ return x; }
    public void setX(int x){ this.x = x; }
}

boolean omg(Foo f){
    Foo c = f.clone();
    c.setX(c.getX() + 1);
    return c.getX() != f.getX();   
}
assert omg(new FooClass());        // OK
assert omg(FooSingleton.INSTANCE); // WTF?