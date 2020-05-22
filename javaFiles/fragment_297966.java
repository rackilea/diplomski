class OuterClass {

    String a = "A";
    String b = "B";
    String c = "C";

    class InnerClass{
        int x;
        public String getA(){
            return a; // access the variable a from outer class
        }
    }

    public static class StaticInnerClass{
        int x;
    }

    public String stringConCat(){
        return a + b + c;    
    }
}


public class Test{

    public static void main(String args[]) {

        OuterClass.StaticInnerClass staticClass = new OuterClass.StaticInnerClass();
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        System.out.println(inner.getA()); // This will print "A"
    }
}