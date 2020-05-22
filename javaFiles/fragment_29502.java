public class Test {

    private String attribute1; // these are the attributes
    private String attribute2;

    public void method1() {
        String localVariable1; // variables local to method1
        String localVariable2;
    }

    public void method2() {
        String localVariable1; // it's ok to reuse local variable names
        String localVariable2; // but you shouldn't name them attribute1
                               // or attribute2, like the attributes
    }

}