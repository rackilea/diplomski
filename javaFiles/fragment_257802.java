public class Example {
    private EventList<Person> eventList = new BasicEventList<Person>();

    public JTable createTable(...) { ... code to generate the table ...}

    public void manipulateTable() {
        // add to the table (via the eventList)
        eventList.add(new Person("Steve Jobs"));
        // remove first object in the table (and the list)
        eventList.remove(0);
        // update a row
        Person p = eventList.get(0);
        p.setName("A N Other");
        eventList.set(0,p); // overwrite the old object in the list

    }
}