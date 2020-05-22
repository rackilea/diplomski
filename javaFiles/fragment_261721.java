public class TestME {
    public static int testme(String ...strings){
        System.out.println(strings.length);
        B b = getInstanceOfB();
        b.cool();
        return strings.length;
    }

    static B getInstanceOfB(){
        return new B();
    }
}