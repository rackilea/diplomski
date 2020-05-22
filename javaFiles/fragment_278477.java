@Override
public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Person person = (Person) o;

      return height != null ? height.equals(person.height) : person1.height == null;
}

@Override
public int hashCode() {
     return height != null ? height.hashCode() : 0;
}