public class Foo
{

    static{  print("foo"); }  // executed during class initialization

    { print("foo"); }  // executed in constructor 

    print("foo");  // Error!

}