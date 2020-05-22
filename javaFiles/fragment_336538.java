@Entity
@Getter @Setter @NoArgsConstructor // You know now what's this!
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "myField", column = @Column(name = "STRING_FIELD"))
    private EmbeddableGeneric<String> myString;

...
}