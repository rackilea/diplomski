public class Foo {
    private final UUID id;
    private final Bar bar;

    Foo(UUID id, Bar bar) {
      this.id = id;
      this.bar = bar;
    }

    public static Foo create(Bar bar) {
        return new Foo(UUID.randomUUID(), bar);
    }
 }