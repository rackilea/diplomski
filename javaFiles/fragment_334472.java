public class Step9d {

public static enum AnEnum {
    CONSTANT1, CONSTANT2;
}

public void method(AnEnum theEnum)
{
    if(theEnum.equals(AnEnum.CONSTANT2))
    {
        //do something
    }
}

public void anotherMethod()
{
    method(AnEnum.CONSTANT1);
}

}