import org.junit.Test;

public class SomeTest {

    @Test
    public void concreteTest(){
        ConcreteTestModel1 asConcreteTestModel1 = getConcreteModel(new ConcreteTestModel1(), ConcreteTestModel1.class);
        asConcreteTestModel1.doSomethingElse();
    }

    @Test
    public void concreteExtendsTest(){
        ConcreteTestModel1 asConcreteTestModelX = getConcreteModel(new ConcreteTestModelX(), ConcreteTestModelX.class);
        asConcreteTestModelX.doSomethingElse();
    }

    private <T extends ConcreteTestModel1> T getConcreteModel(T anyModel, Class<T> classType) {
        return anyModel.as(classType);
    }

    @Test
    public void vanillaCastingTest(){
        AbstractTestModel anyModelX = new ConcreteTestModelX();
        ConcreteTestModel1 asConcreteTestModelX = (ConcreteTestModel1)anyModelX;
        asConcreteTestModelX.doSomethingElse();
    }

    @Test
    public void abstractGenericTest(){
        AbstractTestModel<ConcreteTestModel1> anyModel = new ConcreteTestModel1();
        ConcreteTestModel1 asConcreteTestModel1 = anyModel.as(ConcreteTestModel1.class);
        asConcreteTestModel1.doSomethingElse();
    }

    @Test
    public void failedGenericTest(){
        AbstractTestModel anyModel = new ConcreteTestModel1();
        ConcreteTestModel1 asConcreteTestModel1 = getAs(anyModel);
        asConcreteTestModel1.doSomethingElse();
    }

    private ConcreteTestModel1 getAs(AbstractTestModel<ConcreteTestModel1> anyModel) {
        return anyModel.as(ConcreteTestModel1.class);
    }
}