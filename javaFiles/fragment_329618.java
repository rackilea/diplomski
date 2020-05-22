class EnumEnumeratorDemo {
    enum Foo {
        BAR, BAZ, QUX;
        @Override public String toString() {
            return name().toLowerCase();
        }
    }

    public static void main(String[] args) {
        for (Foo f : new EnumEnumerator<Foo>(Foo.class)) {
            System.out.println(f);
        }
    }
}