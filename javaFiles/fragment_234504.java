public class Person {
    private List<Person> people = new ArrayList<>();

    public Person() {
    }
    public List<Person> getPeople() {
        return people;
    }
    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Stream<Person> people() {
        return people.stream();
    }

    public Stream<Person> peopleLevel(int depth, boolean includeThis) {
        if(depth<0) throw new IllegalArgumentException();
        if(depth==0) return includeThis? Stream.of(this): Stream.empty();
        Stream<Person> sub = people();
        if(depth > 1) sub = sub.flatMap(p -> p.peopleLevel(depth-1, true));
        return includeThis? Stream.concat(Stream.of(this), sub): sub;
    }

    public static Set<Person> getPersonLevel(Person person, int depth) {
        return person.peopleLevel(depth, false).collect(Collectors.toSet());
    }

    public int maxDepth() {
        return maxDepth(false);
    }
    public int maxDepth(boolean includeThis) {
        int chDepth = people().mapToInt(p -> p.maxDepth(true)).max().orElse(0);
        if(includeThis) chDepth++;
        return chDepth;
    }
}