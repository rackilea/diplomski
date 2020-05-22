Public Class A extends javax.swing.JFrame {

    Public A(){
       B panelWithButtons = new B();
    }
}

public Class B extends javax.swing.JPanel{
    String s;
    objectOfC C = C.getInstance();

    this.s = objectOfC.getName();
}

public class C {
    private static String name;
    private static final C INSTANCE = new C();

    private C() {}

    public static C getInstance() {
       return INSTANCE;
    }

    public static String getName() {
        return this.name;
    }
}