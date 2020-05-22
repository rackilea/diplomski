public void method(String aConstant)
{
    if(aConstant.equals(AnEnum.CONSTANT2.getValue()))
    {
        //do something
    }
}

public void anotherMethod()
{
    method(AnEnum.CONSTANT1.getValue());
}