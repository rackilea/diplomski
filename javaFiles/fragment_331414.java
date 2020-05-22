//sorts the people in descending order by first name
people.sort(new Comparator<Person>() {
    public int compare(Person a, Person b) {
       b.firstName.compareTo(a.firstName);
    }
});