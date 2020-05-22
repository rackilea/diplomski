@Immutable
class Person {
    private final Identity identity; // Identity is a mutable type

    public void changeNameTo(String name) {
        identity.changeNameTo(name); // private final can't prevent this
    }
}

@Mutable
class Identity {
    private String name;

    public void changeNameTo(String name) {
        this.name = name;
    }
}