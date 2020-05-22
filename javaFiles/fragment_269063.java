@Entity(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @JsonSerialize(using = CustomSerializer.class)
    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;  

    . . .

}