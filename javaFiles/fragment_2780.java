interface A {
    void show();
}

public class Static {
    public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
        A a = new A() {
            public void show() {
                System.out.println("In anonymous Class");
            };

            public A b = new A() {
                public void show() {
                    System.out.println("In nested Anonymous Class");
                }
            };

        };
        // Get the anonymous Class object
        Class<? extends A> anonymousClass = a.getClass();
        // Get field "b"
        Field fieldB = anonymousClass.getField("b");
        // Get the value of b in instance a and cast it to A
        A b = (A) fieldB.get(a);
        // Show!
        b.show();
    }
}