public class Person implements Comparable<Person> {

    public int compareTo(Person person) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        return sdf.parse(this.dateString).compareTo(sdf.parse(person.dateString));
    }
}