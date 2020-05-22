class Test
{
    private TestFactory factory = null
    protected Test(...) {...}

    public static Test getInstance() 
    {
        if(Condition)
        {
            return factory.getOtherClass();
        }
        else
        {
            return factory.getTestClass();
        }
    }

    public static Test getInstance2() 
    {
       return factory.construct(Condition_Params);
    }
}

public abstract class TestFactory {

    public static Test getTestClass(){
        return new Test();
    }

    public static Test getOtherClass(){
        return new OtherTest();
    }
}