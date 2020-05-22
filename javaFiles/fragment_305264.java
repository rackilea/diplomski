@Bean
public B b(A a) {
    B b = new B();
    b.setA(a);
    a.setB(b);
    return b;
}