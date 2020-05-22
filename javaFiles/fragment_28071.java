//this is the PARENT (FIRST) class extended from the CHILDREN (SECOND)
class FooHelper {
    int theIntCommonValue;

    public int getTheIntCommonValue() {
        return theIntCommonValue;
    }

    public void setTheIntCommonValue(int theIntCommonValue) {
        this.theIntCommonValue = theIntCommonValue;
    }
}

// CHILDREN CLASS, look how calling this.getTheIntCommonValue() (the parent method)
// doesn't throw any error because is taking parent method implementation
class Foo extends FooHelper {
    public void getFooInt() {
        if (this.getTheIntCommonValue() == 0)
            this.setTheIntCommonValue(5);
    }
}
class Foo2 extends FooHelper {
    public void getFooInt() {
        if (this.getTheIntCommonValue() == 3)
            this.setTheIntCommonValue(8);
    }
}