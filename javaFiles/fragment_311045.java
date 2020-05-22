@Entity
@Audited
class User {
  @Formula("SELECT name FROM Other ...")
  @NotAudited
  private String name;
  // other attributes
}