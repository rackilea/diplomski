class Foo
{
    public Foo(String myString, Int32 myInt){
        //Some Initialization stuff here
    }

    //Default value for myInt
    public Foo(String myString) : this(myString, 42){}

    //Default value for both
    public Foo() : this("The Answer", 42){}
}