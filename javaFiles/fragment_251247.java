abstract class SuperType {
    public SuperType(SuperType t) {
    }

    public abstract SuperType deepCopy();
}

class SomeType extends SuperType {

    SomeType(SomeType t) {
        //copy constructor
    }

    @Override
    public SomeType deepCopy() {                        
        return new SomeType(this);
    }
}

 ...

SuperType original = new SubType();
SuperType copy = original.deepCopy(); //the deepCopy is called on children classes