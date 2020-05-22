//First Class
class A
{
    public int num;

public A() {
    num = 3;
}

public void setNum(int newNum) {
    num = newNum;
}

public int getNum() {
    return num;
}
}

//Second Class
public class B
{
public static void main(String[] args) {
    A a = new A();
    C c = new C();

    System.out.println(a.getNum());

    a.setNum(45);

    System.out.println(a.getNum());

    c.printStuff(a);
}
}

//Third Class
class C
{
public void printStuff(A a) {
    //A a = new A();

    System.out.println(a.getNum());
    }
}