@Entity
class User {
  @EmbeddedId
  @AttributeOverride(name="firstName", column=@Column(name="fld_firstname")
  UserId id;

  Integer age;
}

@Embeddable
class UserId implements Serializable {
  String firstName;
  String lastName;
}