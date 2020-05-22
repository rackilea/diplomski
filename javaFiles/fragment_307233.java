@Entity
@Table(name = "role_to_user")
public class RoleAssignment {

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;

    private Date startDate;

    private Date endDate;

}