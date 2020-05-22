public class HelloWorldForm extends ActionForm {
    private final Factory personFactory = new Factory() {
        @Override public Object create() { return new PersonForm(); }
    };
    // commons-collection 4 offers a LazyList<E> with generics
    private List lazyPersons = LazyList.decorate(new ArrayList(), personFactory);

    public List<PersonForm> getPersons() {
        return lazyPersons;
    }
    public void setPersons(List<PersonForm> persons) {
        this.lazyPersons = LazyList.decorate(persons, personFactory);
    }
}