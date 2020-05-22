List<Wrapper<Wrapper<?>>> ls1 = new ArrayList<>();

And

Wrapper<Wrapper<?>> l1 = new Wrapper<>(new Wrapper<>(t));
ls1.add(l1); // OK