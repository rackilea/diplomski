public class AgeComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {
        if(p1.getAge() < p2.getAge()) return -1;
        else if(p1.getAge() > p2.getAge()) return 1;
        else return 0;
    }

    public boolean equals(Person p1, Person p2) {
        return this.compare(p1, p2) == 0;
    }
}