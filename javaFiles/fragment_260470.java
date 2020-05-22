@Entity
@Table(name = "wrong_right_role")
public class WrongRightRole{
    @EmbeddedId
    WrongRightRoleId wrongRightRoleId;

    @MapsId("rightRoleID")
    @JoinColumns({
        @JoinColumn(name = "roleID", referencedColumnName = "roleID"),
        @JoinColumn(name = "rightID", referencedColumnName = "rightID")
    })
    RightRole rightRole;

}

@Embeddable
public class WrongRightRolePK implements Serializable {
private static final long serialVersionUID = 1L;

  private RightRoleID rightRoleID;
  .....
}