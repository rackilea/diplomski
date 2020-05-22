public class MyClassTest {

    public static void main(String[] args) {
        MyClass myClass = new MyClass.MyClassBuilder(10,20).build();
    // without optional param
    System.out.println("without optional param");
    System.out.println("attr1 "+ myClass.getAttr1());
    System.out.println("attr2 "+ myClass.getAttr2());
    System.out.println("attr3 "+ myClass.getAttr3());

    // with optional param
    System.out.println("with optional param");
    MyClass myClassWithAllParam = new MyClass.MyClassBuilder(10,20).setAttr1(5).build();
    System.out.println("attr1 "+ myClassWithAllParam.getAttr1());
    System.out.println("attr2 "+ myClassWithAllParam.getAttr2());
    System.out.println("attr3 "+ myClassWithAllParam.getAttr3());

    }
}