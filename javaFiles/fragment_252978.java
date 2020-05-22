Public Class A extends javax.swing.JFrame {

    Public A(){
       C objectOfC = new C();
       B panelWithButtons = new B(objectOfC);
    }
}

public Class B extends javax.swing.JPanel{

    String s;

    public B (C objectOfC) {
        this.s = objectOfC.getName();
    }
}

public Class C{
    String name;
    public String getName(){
    return this.name;
    }
}