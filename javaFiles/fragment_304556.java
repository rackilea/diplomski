interface MyInterface
{}
public class InterfaceTest implements MyInterface
{
    public static void main(String[] args) 
    {
        MyInterface mInterface = new InterfaceTest();
        System.out.println(mInterface.toString());//Compiles successfully. Although toString() is not declared within MyInterface
    }
}