class C {}

C v1 = C() {
    void meth() {
        puts("I am only available in instance v1");
    }
};
C v2 = new C();

// prints -> I am only available in instance v1
v1.getClass().getMethod("meth").invoke(v1); 
// throws NoSuchMethodException
v2.getClass().getMethod("meth").invoke(v2);