@Entity
public class Person {
    ...
    @ElementCollection
    @CollectionTable(name = "PERSON_LOCATIONS", joinColumns = @JoinColumn(name = "PERSON_ID"))
    @OrderColumn
    private List<Location> locations;
    ...
}