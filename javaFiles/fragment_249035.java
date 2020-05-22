class Group {
    List<Person> people;
    void removePerson(Person p) {
        if(people.remove(p))
            p.removeFromGroup();
    }
}

class Person {
    Group grp;
    void removeFromGroup() {
        grp.removePerson(this);
        grp = null;
    }
}