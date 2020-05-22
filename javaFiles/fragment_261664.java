@MyCustomAnnotation(name="someVal")
class MyClass{

    @GET
    @MyCustomAnnotation(name="someConfig")
    public Object myMethod(){
    ...
    }

    @GET
    @MyCustomAnnotation(name="otherConfig")
    public Object myOtherMethod(){
    ...
    }

}