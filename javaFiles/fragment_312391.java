@Table('myTable')
@IdClass(ComposedKey.class)
public class myEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    private String identity;

    private String otherFields;

}

public class ComposedKey implements Serializable {
    private long id;
    private String identity;

    //Getter / Setter

}