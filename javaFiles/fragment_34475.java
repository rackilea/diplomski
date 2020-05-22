import java.util.Scanner;

class OtherClass {

    public String name;

    public OtherClass(String name){

        this.name = name;

    }

}

public class MyClass {

    int x;
    OtherClass a;
    OtherClass b;

    public MyClass(){

        Scanner scanner = new Scanner(System.in);


        this.a = new OtherClass(scanner.next());
        this.b = new OtherClass(scanner.next());
        // always close resources after use
        scanner.close();
    }

    //  testing
    public static void main(String args []){

        MyClass myClass = new MyClass();

        System.out.println("the name in OtherClass a is: "+myClass.a.name);
        System.out.println("the name in OtherClass b is: "+myClass.b.name);

    }

}