import org.junit.Test;

public class SomeTest {

    @Test
    public void someTest(){
        AbstractTestModel<ConcreteTestModel1> anyModel = new ConcreteTestModel1();
        ConcreteTestModel1 asConcreteTestModel1 = anyModel.as(ConcreteTestModel1.class);
        asConcreteTestModel1.doSomethingElse();

        AbstractTestModel anyModelX = new ConcreteTestModelX();
        ConcreteTestModel1 asConcreteTestModelX = (ConcreteTestModel1)anyModelX;
        asConcreteTestModelX.doSomethingElse();
    }
}