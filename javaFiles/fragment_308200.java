public class OuterClass {
    class InnerClass {
        void method() {
            // Refer to outer class instance
            doSomething( OuterClass.this );
        }

        void doSomething(OuterClass outer) {
            // ...
        }
    }
}