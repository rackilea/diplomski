public Class A
{

    public func1()
    {
       B object = newB();
       int x = object.func2(something);
    }

    protected B newB(){
        return new B();
    }
}