List<? super B> list3 = new ArrayList<A>() {
    {
        add(new A());
        add(new B());
        add(new C());
    }
};

list3.add(new A()); // compilation error