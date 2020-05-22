public class A extends javax.swing.JFrame {

    public A() {
        C objectOfC = C.getInstance();
        objectOfC.setName("Bob");
        B panelWithButtons = new B(objectOfC);
        System.out.println("objectOfC_A:" + objectOfC.getName()); //return "George"
    }
}

public class B extends javax.swing.JPanel {
    public B (C objectOfC) {
        C c2 = C.getInstance();

        objectOfC.setName("Fred");
        c2.setName("George");
        System.out.println("objectOfC_B:" + objectOfC.getName()); //returns "George"
        System.out.println("c2: " + c2.getName()); //returns "George"
    }

}

public class C {
    private static String name;
    private static final C INSTANCE = new C();

    private C() {}

    public static C getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return C.name;
    }

    public void setName (String name) {
        C.name = name;
    }
}