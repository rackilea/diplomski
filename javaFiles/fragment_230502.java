@Entity
public class Person {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST) // or ALL to cascade all operations
    private City city;

    // ...
}