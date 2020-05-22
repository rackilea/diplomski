@Override
public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

     Person person = (Person) o;

     return height == person.height;
}

@Override
public int hashCode() {
     return height;
}