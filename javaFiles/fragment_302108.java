@Entity
@IdClass(UserPK.class)
public class User{
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Id
    @JoinColumn(name = "project", referencedColumnName = "id_project")
    @ManyToOne(optional = false)
    private Project project;
}

public class UserPK{
    private Integer id;
    private Integer project;//use the same type as the Project's ID.
}