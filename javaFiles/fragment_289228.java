@Entity
@SecondaryTable(name="user_password",
                pkJoinColumns=@PrimaryKeyJoinColumn(name="user_id"))
public class User implements Serializable {
    ...
    @Column(table = "user_password", name = "password" )
    private String password;
    ...
}