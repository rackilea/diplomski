class B {

    class C {
        void m4() {
            A.m2(new I() {
                public void m1(int arg1) {
                    m1Foo();// Getting compilation error here.
                }
            });
        }

        void m1Foo() {
            System.out.println("Inside M1");
        } 

    }
}