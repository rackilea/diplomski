@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    ...
    @OneToMany(mappedBy="user")
    private Set<Address> adresses;
} 


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    ...
    @ManyToOne(optional=false)
    @JoinColumn("your_foreign_key_name")
    private User user;
}