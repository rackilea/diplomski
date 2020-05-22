class B {

    class C {
        void m4() {
            A.m2(new I() {
                public void m1(int arg1) {
                    C.this.m1(); 
                }
            });
        }

        void m1() {
            System.out.println("Inside M1");
        } 

    }
}