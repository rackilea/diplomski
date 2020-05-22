import java.lang.reflect.Field;

class MyClass {
    String f1;
    String str;
    String f2;
}

class Test {
    public static void main(String[] args) throws Exception {
        Field[] f = MyClass.class.getDeclaredFields();
        MyClass cl = new MyClass();
        cl.str = "hello world";

        int strIndex = 0;
        while (!f[strIndex].getName().equals("str"))
            strIndex++;

        System.out.println(f[strIndex].get(cl));

    }
}