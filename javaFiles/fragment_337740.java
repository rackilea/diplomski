class ClassInMethod {
    public static void main(String[] args) {
        int local = 1;

        // this happens when you do: new Inner()
        ClassInMethod_main_Inner inner = new ClassInMethod_main_Inner();
        inner.local = local;
    }
}

// the inner class
class ClassInMethod_main_Inner {
    int local;

    public void method() {
        System.out.println(local);
    }
}