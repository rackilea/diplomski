class C1 {
    void methodA() {MyInfo.showStack();}
    void methodB() {methodA();}
}

class C2 {
    static void methodX() {
        C1 c1 = new C1();
        c1.methodB();
    };
    //TEST
    public static void main(String[] args) {
        C2.methodX();
    }
}