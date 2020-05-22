public class Main {

    public static void main(String[] args) {
        OuterClass.NestedClass.NestedClass1 nc1 = new OuterClass.NestedClass.NestedClass1();
        OuterClass.NestedClass.NestedClass1.NestedClass2 nc2 = nc1.new NestedClass2();
        nc2.m1();
    }
}