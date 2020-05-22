class Object1 {
    //...stuff...
}

class Decorator {
    private Object1 object;
    public Decorator(Object1 obj) {
        object = obj;
    }
    public Object1 getComposite() {
        return object;
    }
    public void extra() {
        //Do stuff with object1 and any other state specific to the decorator
    }
}