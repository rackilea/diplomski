@Entity
public class Institution{

    @OneToMany(mappedBy = "institution")
    private Set<User> users;
}

@Entity
public class User {

    @ManyToOne
    @JoinColumn(name = "acronym", referencedColumName = "acronym")
    private Institution institution;

}