@Entity
@Table(name="users")
@SecondaryTable(name="rights", pkJoinColumns=
    @PrimaryKeyJoinColumn(name="userid", referencedColumnName="userid")
)
public class User {

...

@Column(name = "enabled", table="rights")
private Long enabled; // in rights table