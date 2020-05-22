public void f1(A a){
    if(a instanceof B) {
        B b = (B)a;
        b.f1(b);
    } else {
        System.out.println("Nothing");
    }
}