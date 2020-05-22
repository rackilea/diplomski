List<A> aList = new ArrayList<>();
List<B> bList = new ArrayList<>();

aList.stream()
        .filter( a  -> a.dob == null)
        .forEach( a -> {
            Predicate<B> nameFilter = b -> b.name.equals(a.name);
            a.dob = findDob(nameFilter, bList);
        });

static String findDob(Predicate<B> nameFilter, List<B> bList) {
    B b = bList.stream()
            .filter(nameFilter)
            .findFirst()
            .orElse(new B());

    return b.dob;
}