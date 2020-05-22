public class Test ()
{
    String myMethod () {
        return hashCode() + " ";
    }
    String myMethod (Test other) {
        return hashCode() + " ";
    }
    public void test () {
        List<Test> list = new ArrayList<>();
        list.add (new Test());
        list.add (new Test());
        System.out.println (this.hashCode ());
        // this will execute myMethod () on each member of the Stream
        list.stream ().map (Test::myMethod).forEach (System.out::print);
        System.out.println (" ");
        // this will execute myMethod (Test other) on the same instance (this) of the class
        // note that I had to overload myMethod, since `map` must apply myMethod
        // to each element of the Stream, and since this::myMethod means it
        // will always be executed on the same instance of Test, we must pass
        // the element of the Stream as an argument
        list.stream ().map (this::myMethod).forEach (System.out::print);
    }
    public static void main (java.lang.String[] args) { 
        new Test ().test ();
    }
}