public void test() {
    a = 1;  // have access to inherited protected field or 
    chat(); // methods of base class 
}

public static void main(String[] args) {
    Second f = new Second();
    f.chat();
    System.out.println(f.a);
}