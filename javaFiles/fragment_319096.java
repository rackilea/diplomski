package main;

public class Person implements Comparable<Person> {
    private final String rank;
    private final int points;

    public Person(String rank, int points) {
        this.rank = rank;
        this.points = points;
    }

    public String rank() {
        return rank;
    }

    public int points() {
        return points;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return person.rank.equals(rank) && person.points == points;
    }

    // public int hashCode() {
    //    return your hash;
    // }

    public String toString(){
        return "Rank: " + rank +", points = " + points ;
    }

    public int compareTo(Person person) {
        return points > person.points ? 1 : points < person.points ? -1 : 0;
    }
}