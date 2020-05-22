@Id
@GeneratedValue(generator="gen")
@GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="user"))
public int getId() {
    return id;
}

@OneToOne
@PrimaryKeyJoinColumn
public User getUser() {
    return user;
}