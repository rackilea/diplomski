@PostMapping
public ResponseEntity<?> create(@Valid @RequestBody DTOClient client) {
       ....

        return responseEntity;
    }

public class DTOClient{

//What I should use here to validate these entities?
    @Valid
    @NotNull(message="client should not null")
    private Client client;
    private Skill skill;

}

@Entity
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="first name of client should not be null or blank")
    private String first_name;

    private String last_name;
}

@Entity
public class Skill{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int year;
}