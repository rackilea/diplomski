class MyList extends ArrayList
{

{ // This is an instance initializer; the code is invoked before the constructor.
add("first"); 
add("second");
}

public MyList() {
    super();
    // I believe initializers run here, but I have never specifically tested this
    }
}