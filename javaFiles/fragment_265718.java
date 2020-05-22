public class Outer {

    private static String staticOuterField;
    private String outerField;

    public void method() {
        class MethodInner {
            public void methodInnerMethod() {
                System.out.println(staticOuterField); // OK
                System.out.println(outerField); // OK
            }
        }
    }

    public static void staticMethod() {
        class StaticMethodInner {
            public void staticMethodInnerMethod() {
                System.out.println(staticOuterField); // OK
                System.out.println(outerField); // Not accessible
            }
        }
    }

    static class StaticInner {
        public void staticInnerMethod() {
            System.out.println(staticOuterField); // OK
            System.out.println(outerField); // Not accessible
        }
    }

    class Inner {
        public void innerMethod() {
            System.out.println(staticOuterField); // OK
            System.out.println(outerField); // OK
        }
    }
}