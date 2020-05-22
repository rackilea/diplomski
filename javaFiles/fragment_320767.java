class B {

    class C {
        void m4() {
            A.m2(arg1 -> m1());
        }
        void m1() {
            System.out.println("Inside M1");
        }
    }
}