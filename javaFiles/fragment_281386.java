static class ParentThing {

}

static class ChildThingOne extends ParentThing{

}

interface Validator<T extends ParentThing> {
    void validate(T item);
}

static class ValidatorImplOne implements Validator<ChildThingOne> {
    @Override
    public void validate(ChildThingOne thing1) {
        // whatever
    }
}


public static void validate(String s, ParentThing thing) {
    Validator<? extends ParentThing> validator = new ValidatorImplOne(); //? extends ParentThing means an unknown, but SPECIFIC, implementation of ParentThing

    validator.validate(new ChildThingOne()); //cannot compile
    //The compiler doesn't know if ChildThingOne is the actual type validator wants
}