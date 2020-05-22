@Embeddable
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="interest")
    private String interest;

    @Column(name="festival_number", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="festival_info"))
    private String festivalNumber;

     // and getters and setters here
}