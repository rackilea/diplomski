public class AClass {
public void m1() {
    System.out.println("A.m1()");
    this.m2();
}
public void m2() {
    System.out.println("A.m2()");
}

public static void main(String [] args) {
    AClass A = new AClass();
    BClass B = new BClass();

    B.m1();
}

public class BClass extends AClass {

@Override
public void m2() {

    // TODO Auto-generated method stub
    System.out.println("B.m2()");
    super.m1();
}

}