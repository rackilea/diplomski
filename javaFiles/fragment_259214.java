public class SuperClass {
    protected int x;
}
public class SubClass extends SuperClass {
    private int x;
    public SubClass(int x) {
        x = 2; // sets the parameter variable
        this.x = 2; // sets the instance variable
        super.x = 2; // sets the super class' instance variable
    }
}