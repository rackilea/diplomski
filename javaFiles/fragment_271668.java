@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
@SequenceGenerator(name = "sequenceGenerator")
private Long id;

@NotNull
@Pattern(regexp = Constants.LOGIN_REGEX)
@Size(min = 1, max = 50)
@Column(length = 50, unique = true, nullable = false)
private String login;

@JsonIgnore
@NotNull
@Size(min = 60, max = 60)
@Column(name = "password_hash", length = 60, nullable = false)
private String password;

@Size(max = 50)
@Column(name = "first_name", length = 50)
private String firstName;

@Size(max = 50)
@Column(name = "last_name", length = 50)
private String lastName;

@Email
@Size(min = 5, max = 254)
@Column(length = 254, unique = true)
private String email;

@NotNull
@Column(nullable = false)
private boolean activated = false;