@Override
public int deletePerson(int id) {
    try {
        Person person = em.find(Person.class, id);
        em.remove(person);
        return 1;
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }