class A {
    int x = 1;

    class B {
        int x = 2;

        void func(int x) {
            System.out.println(A.this.x);
        }
    }
}