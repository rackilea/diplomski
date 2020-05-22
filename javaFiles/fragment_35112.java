public class Foo {
    public Foo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @override
    public boolean equals(Object other) {
        Foo otherFoo;

        if (other == null || !(other instanceof Foo)) { // or you might be more restrictive
            return false;
        }

        otherFoo = (Foo)other);
        return otherFoo.x == this.x && otherFoo.y == this.y;
    }

    @override
    public int hashCode() {
        // ...appropriate implementation of hashCode...
    }
}

Foo a = new Foo(0, 0);
Foo b = new Foo(0, 0);
System.out.println(a == b);      // "false"
System.out.println(a.equals(b)); // "true"