private Person getPersonByFirstName(String firstName) {
    for (Person p : employeeHM.values()) {
        if (p.getFirstName().equals(firstName))
           return p;
    }
    return null;
}