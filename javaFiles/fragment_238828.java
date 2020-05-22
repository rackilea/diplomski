public class Main{

     public static void main(String []args){
        MyEnum value = MyEnum.X;

        System.out.println("With Base:");
        Base base = new Base();
        System.out.println(base.showVal(value));//prints "a=0,b=2"

        System.out.println("With A:");
        A a = new A();
        System.out.println(a.showVal(value));   //prints "a=10,b=11"

        System.out.println("With B:");
        B b = new B();
        System.out.println(b.showVal(value));   //prints "a=20,b=21"

     }
}