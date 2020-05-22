@Entity
@Table(name="MEMBER_DETAILS")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="GROUPNAME", discriminatorType=DiscriminatorType.STRING, length=20)
public class Member_Details implements Serializable
{
  @Id
  private String e_mail;
  private String password;
  // ...
}