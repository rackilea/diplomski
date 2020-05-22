for (Iterator<Person> it = recipients.iterator(); it.hasNext();) {
    Person p = it.next();
    if (p.getId() == person_ID) { // <-- supposed that getId() exists
        it.remove();
    }
}