for (Iterator<Person> iterator = l.iterator(); iterator.hasNext(); ) {
    Person s = iterator.next();
    if (s.name.equals("b")) {
        iterator.remove();
    }
}