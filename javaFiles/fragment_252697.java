public class Test {
    Object propertyObj1;
    Object propertyObj2 = null; // assigning null is redundant here as instance vars get default values 

    public void method() {
        Object localVariableObj1;
        Object localVariableObj1.getClass(); // illegal, a compiler error comes up as local vars don't get default values

        Object localVariableObj2 = null;
        Object localVariableObj2.getClass(); // no compiler error as localVariableObj2 has been set to null

        propertyObj1.getClass(); // no compiler error
        propertyObj2.getClass(); // no compiler error
    }
}