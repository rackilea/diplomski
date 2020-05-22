package forum11870107;

import java.util.*;

public class PersonCollectionResponse {
    private Set<Person> people = new HashSet<Person>();

    public Set<Person> getPeople() {
        return this.people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public int getCount() {
        return this.people.size();
    }

}