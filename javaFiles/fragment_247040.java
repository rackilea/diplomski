public class Test1 {
    static int a=getA();
    static{
        a=20;  
        System.out.println(a);
    }

    private static int getA() {
        return 10;
    }
    public static void main(String[] args) {
        System.out.println(a);
    }
}