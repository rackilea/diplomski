public static void main(String... args) {
    Wrapper<A, B> wrapper = new Wrapper<A, B>((a) -> new B(a));

    A a = new A();
    B b = wrapper.transform(a);

    System.out.println(b.getValue());

    wrapper = new Wrapper<A, B>(A.class, B.class);
    b = wrapper.transform(a);
    System.out.println(b.getValue());
}