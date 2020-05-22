class Parent {

    int a;

    Parent() {
        System.out.println("parent");
    }

    Parent(boolean unused){
       //do nothing
    }
}

class Child extends Parent {

    Child() {
        super(false);
        System.out.println("child");
    }

}

public class Test2 {

    public static void main(String args[]) {
        Child a = new Child();
    }
}