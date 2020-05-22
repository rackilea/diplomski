class C <T extends root> {

    T element;

    public C(T element) { this.element = element; }

    public go() { element.say(); }
}

//...

C c = new C<A>(new A()); c.go();