public class Initial {
public static final String CONSTANT1 = "value1";
public static final String CONSTANT2 = "value2";

public void method(String aConstant)
{
    if(aConstant.equals(CONSTANT2))
    {
        //do something
    }
}

public void anotherMethod()
{
    method(CONSTANT1);
}

}