class Outer {

static class nestedStaticClass {

//its member variables and methods (don't nessarily need to be static)
//but cannot access members of the enclosing class
}

public void OuterMethod(){
//can access members of nestedStaticClass w/o an instance
}
}