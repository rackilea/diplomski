import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User extends Model {

  @Id
  @GeneratedValue
  private Long userId;

  @Constraints.MaxLength(50)
  private String name;
  @Constraints.MaxLength(100)
  private String surname;

  @Constraints.Required
  @Constraints.MinLength(8)
  private String password;

  @Constraints.Email
  @Constraints.Required
  private String email;

  @Constraints.Required
  @Constraints.MaxLength(10)
  @Constraints.MinLength(10)
  @Constraints.Pattern("[0]\\d{2}[- ]{0,1}\\d{3}[- ]{0,1}\\d{4}")
  private String cellNumber;

  private Boolean emailVerified = false;
  private String token;

  public static Finder<String, User> find = new Finder<String, User>(User.class);

  public User(){}

}