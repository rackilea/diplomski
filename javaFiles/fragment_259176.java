public abstract class ClassA {
    protected SomeEnum name;
    protected int some_int;

    public ClassA(int someConst, int some_int2) {
    }

    @Override
    public String toString() {
        return name.toString().toLowerCase() + " > "
                + Integer.toString(some_int);
    }

}