public class UserGroup implements Iterable<User> {
    private final List<User> people = new ArrayList<User>();

    public Iterator<User> iterator() {
        return people.iterator();
    }
    // OR to prevent the list being modified.
    public Iterator<User> iterator() {
        return Collections.unmodifableList(people).iterator();
    }
    // OR for extra paranoia
    public Iterator<User> iterator() {
        return Collections.unmodifableList(new ArrayList<Person>(people)).iterator();
    }
    // OR for even more paranoia
    public Iterator<User> iterator() {
        List<People> ret = new ArrayList<People>();
        for(People p : people)
            ret.add(new Person(p)); // take a deep copy.
        return Collections.unmodifableList(ret).iterator();
    }
}

// later
UserGroup userGroup = ...
for(User u : userGroup) {
   // do something with u
}