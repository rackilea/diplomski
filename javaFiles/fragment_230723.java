class Bar { }

class FooBar { }

public class Demo {

    public static void main() {
        new Demo().method();
    }

    public void method() {
        new Bar() {

            void otherMethod() { System.out.println("Hello"); }

            void barMethod() {

                new FooBar() {

                    void fooBarMethod() {
                        otherMethod(); // not compiles
                    }   
                }.fooBarMethod();
            }
        }.barMethod();
    }
}