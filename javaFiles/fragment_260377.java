import java.lang.reflect.*;
class Dummy{
    private void foo(){
        System.out.println("hello foo()");
    }
}

class Test{
    public static void main(String[] args) throws Exception {
        Dummy d = new Dummy();
        Method m = Dummy.class.getDeclaredMethod("foo");
        //m.invoke(d);// throws java.lang.IllegalAccessException
        m.setAccessible(true);// Abracadabra 
        m.invoke(d);// now its OK
    }
}