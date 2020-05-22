import java.lang.reflect.Method;


public class Test001 {

    public static void main(String[] args) throws Exception {
        Test002 obj = new Test002();
        Method m = obj.getClass().getDeclaredMethod("testMethod", int.class);
        m.setAccessible(true);

        m.invoke(obj, 10);
        m.invoke(obj, 20);

        System.out.println(m.getName());
    }


}

class Test002 {
    private void testMethod(int x){
        System.out.println("Hello there: " + x);
    }       
}