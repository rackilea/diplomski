public class Foo {
    private Bar hidden;
    private String accessible;

    @Override
    public boolean equals( Object ob ) {
       return hidden.equals(((Foo)ob).hidden);
    }

    @Override
    public int hashCode() {
       //Let's not forget that we MUST override hashCode() if we override equals() :)
    }
}