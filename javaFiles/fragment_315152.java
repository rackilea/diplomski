@Stateless
public class BusinessObjectImpl implements BusinessObject {

    @In
    private AnotherObject anotherObject;

    public void doSomething(SomeObject i01, SomeObject i02) {
       anotherObject.someMethod(i01, i02);    
    }

}