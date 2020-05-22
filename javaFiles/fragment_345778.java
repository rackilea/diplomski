public LinkedList<String> check() {

  LinkedList<String> names = new LinkedList<String>();

  for (Person person: passengers) {
    names.add( person.getName() );
  }

  return names;
}