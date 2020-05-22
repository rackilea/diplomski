interface Group {
    List<Person> getPeople();
    void setPeople(List<? extends Person> people);
}
class AbstractGroup implements Group {
    final ArrayList<Person> people=new ArrayList<>();

    public List<Person> getPeople() {
      return people; // or Collections.unmodifiableList(people)
    }

    public void setPeople(List<? extends Person> people) {
      this.people.clear();
      this.people.addAll(people);
    }
}