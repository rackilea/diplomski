class PersonDumper {

    // attributes

    public PersonDumper(Appendable output, Set<Person> persons) {
        // do stuff
    }

    public dump() {
        for(Person p : persons) {
            // String.valueOf rather than .toString to be null-safe
            output.append(String.valueOf(p));
            output.append(",");
        }
    }
}