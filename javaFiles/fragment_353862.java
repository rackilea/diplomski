class SomeClassFactory
{
    public SomeClass createSomeClassWithOneParam(Parameter a) 
    {
        return new SomeClassWithOneParameter(a);
    }

    public SomeClass createSomeClassWithTwoParams(Parameter a, Parameter b) 
    {
        return new SomeClassWithTwoParameters(a, b);
    }

}