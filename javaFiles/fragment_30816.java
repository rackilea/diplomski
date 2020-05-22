public class Main {
    interface Person {
    }

    interface Aggregate<T> extends Person, Iterable<T> {
    }

    public static List<Person> getPeopleList(List<Aggregate<Person>> aggregateList) {
        List<Person> resultList = new ArrayList<Person>();
        for (Aggregate<Person> aggregate : aggregateList) {
            resultList.add(aggregate);

            for (Person person : aggregate) {
                resultList.add(person);
            }
        }
        return resultList; // the result is person and aggregate list
    }

    public static void main(String... args) {
        Aggregate<Person> aggregate = mock(Aggregate.class);
        Aggregate<Person> aggregate2 = mock(Aggregate.class);
        Person person = mock(Person.class);
        Person person2 = mock(Person.class);
        when(aggregate.iterator()).thenReturn(Arrays.asList(person).iterator());
        when(aggregate2.iterator()).thenReturn(Arrays.asList(person2).iterator());

        List<Person> list = getPeopleList(
                Arrays.asList(aggregate, aggregate2));
        System.out.println(list);
        System.out.println("size: " + list.size());
    }
}