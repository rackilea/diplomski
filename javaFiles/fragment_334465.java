private static final String CONSTANT1 = "value1";
private static final String CONSTANT2 = "value2";

public void method(String aConstant)
{
    if(aConstant.equals(getConstant2()))
    {
        //do something
    }
}

public void anotherMethod()
{
    method(getConstant1());
}

public static String getConstant1() {
    return CONSTANT1;
}

public static String getConstant2() {
    return CONSTANT2;
}