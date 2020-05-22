public interface MyInterface {
    public void print();

}

@Stateless
@Remote(MyInterface.class)
public class MyBean extends MyAbstractClass{

    @Override
    public void print() {
        System.out.println("MyAbstractClassExtender.PRINT");

    }

}