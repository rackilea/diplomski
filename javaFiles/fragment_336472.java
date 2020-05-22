List<Foo> foosHandedOutByMe = ...
public Foo findVariable(Foo foo) {
    Foo f = new Foo();
    foosHandedOutByMe.add(f);
    return f;
}