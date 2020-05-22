public class A{
    private A objectOfTheSameClass;
    public A() {
       objectOfTheSameClass= this();
    }
}