public Person searchPerson (String name) {
    for (Person person: persons) {
        if (name != null && name.equals( person.getName())) {
          return person;
        }
    }
    System.out.println("We can not found Person with name " + name);
    return null; 
}