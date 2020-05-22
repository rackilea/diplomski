Person tmp = null;
for (Person person : persons) {
    if (tmp != null && tmp.getLastDiscovered() == person.getLastDiscovered()) {
        getHelper().delete(tmp);
    }
    tmp = person;
}