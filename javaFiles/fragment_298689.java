final B b1 = null;
    new B() {
        {
            System.out.println(this.m(b1, b1));
        }
        int m(B a, B b) { return 10; }
    };