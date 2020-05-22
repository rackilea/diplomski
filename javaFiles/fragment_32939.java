import java.lang.reflect.*;

class Foo {
    class Bar {
        public Bar(int a) {
        }
    }

    public static void main(String[] args) {
        for(Constructor c: Bar.class.getDeclaredConstructors()) {
            System.out.println(c);
        }   
    }
}