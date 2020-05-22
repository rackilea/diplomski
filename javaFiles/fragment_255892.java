class B1 extends A1 {

    public boolean foo() {
        return !(new C1().foo());
    }
}