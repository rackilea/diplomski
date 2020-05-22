@Override
public int compareTo(Person person) {
  int rv = this.givenName.compareToIgnoreCase(person.givenName);
  if (rv != 0) return rv;
  else return this.surname.compareToIgnoreCase(person.surname);
}