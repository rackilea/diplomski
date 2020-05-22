public void serializePerson(String filename, List<Person> persons) {
    try (FileOutputStream fos = new FileOutputStream(filename);
         ObjectOutputStream ous = new ObjectOutputStream(fos)) {

        ous.writeInt(persons.size());
        for (Person person : persons) {
            ous.writeObject(person);
        }
    } catch (Exception e) {
    }
}

public List<Person> deserializePerson(String filename) {
    List<Person> result = new ArrayList<>();
    try (FileInputStream fis = new FileInputStream(filename);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            Person person = (Person) ois.readObject();
            result.add(person);
        }
    } catch (Exception e) {
    }
    return result;
}