@Override
public void f() {
    //Anything that access o.
    o.hashCode(); //Throws NullPointerException as o has not been initialised yet
    super.f();
}