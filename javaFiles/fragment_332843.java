class Parent{
    Child child;
    Random r = new Random();

    public Parent()
    {
        child = new Child(r);
    }
}

class Child{    
    public Child(Random r){

    }    
}