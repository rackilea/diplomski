interface Fooable 
{
}

abstract class MyClass 
    implements Fooable 
{
}

interface MyInterface 
    extends Fooable 
{
}

class MyConcreteClass 
{
    private Fooable value;
}