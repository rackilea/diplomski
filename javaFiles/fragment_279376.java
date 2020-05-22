interface C {
    void meth();
}

C v1 = () -> puts("I am only available in instance v1");
C v2 = () -> { throws new UnsupportedOperationException(); }

v1.meth();
v2.meth();