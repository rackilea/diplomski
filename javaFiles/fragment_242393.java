public class Person {
    private final List<Person> friends = new ArrayList<Person>();

    public void addFriend(Person friend) {
        friends.add(friend);
    }

    ...
}