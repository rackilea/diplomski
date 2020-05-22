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

public static Optional<MyObject> findFirstByFilter(final List<MyObject> myObjects, final Predicate<MyObject> filter) {

    return FluentIterable.from(myObjects)
            .firstMatch(filter);
}

public static Optional<MyObject> findFirstById(final List<MyObject> myObjects, final Integer id) {

    return findFirstByFilter(myObjects, new Predicate<MyObject>() {

        @Override
        public boolean apply(final MyObject myObject) {

            return myObject.getId() == id;
        }
    });
}

public static void main(final String... args) {
    final List<MyObject> myObjects = ImmutableList.of(new MyObject(1), new MyObject(2));

    final Optional<MyObject> found = findFirstById(myObjects, 2);

    //MyObject [id=2]
    System.out.println(found.orNull());

    final Optional<MyObject> notFound = findFirstById(myObjects, 5);

    //null
    System.out.println(notFound.orNull());
}