@Entity
public class Account {

    @Id
    private Long id;

    // other fields...
    // some of them are unique

    @OneToOne(mappedBy = "account")
    private Credential credential;
    // omitted

}


@Entity
public class Credential {

    @Id
    private Long id;

    @OneToOne
    private Account account;

}