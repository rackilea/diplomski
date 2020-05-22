public class TestME {
    public static int testme(String ...strings){
        System.out.println(strings.length);
        B b = new B();
        b.cool();
        return strings.length;
    }
}