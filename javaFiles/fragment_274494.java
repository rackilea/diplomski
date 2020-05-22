import java.lang.reflect.*;

class Example {

    interface I {
        Runnable r = () -> {}; // lambda

        void m();
    }

    public static void main(String[] args) {
        for (Method method : I.class.getDeclaredMethods()) {
            System.out.println("name: " + method.getName());
            System.out.println("isSynthetic: " + method.isSynthetic());
            System.out.println();
        }
    }
}