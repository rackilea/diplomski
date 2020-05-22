@MessageType
public class OtherController  {

    @MessageId(id=101)
    public void method1()
    {
        System.out.println("executing method1");
    }
    @MessageId(id=102)
    public void method2()
    {
        System.out.println("executing method2");
    }
}