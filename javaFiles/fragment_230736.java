public class Test{
    private static Random r = new Random();
    private static A[] arr = new A[] {
        new B(), 
        new C()
    };
    public static A check(){
        return arr[r.nextInt(arr.length)];
    }
}