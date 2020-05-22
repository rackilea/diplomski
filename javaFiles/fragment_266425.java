private final int id;

public MyObject(final int id) {
    this.id = id;
}

public int getId() {
    return this.id;
}

@Override
public String toString() {
    return "MyObject [id=" + this.id + "]";
}

public static void main(final String... args) {

    final List<MyObject> myObjects = ImmutableList.of(new MyObject(1), new MyObject(2));

    final Optional<MyObject> found = myObjects.stream()
        .filter(myObject -> myObject.getId() == 2)
        .findAny();

    // MyObject [id=2]
    System.out.println(found.orElse(null));

    final Optional<MyObject> notFound = myObjects.stream()
        .filter(myObject -> myObject.getId() == 5)
        .findAny();

    // null
    System.out.println(notFound.orElse(null));
}