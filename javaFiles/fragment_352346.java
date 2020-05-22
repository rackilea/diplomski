@Entity  
class User {

  @Id
  @GeneratedValue
  @JsonView(UserSerializer.User.class)
  private Long id;

  @JsonView(UserSerializer.User.class)
  private String username;

  @JsonView(UserSerializer.User.class)
  private String email;

  @OneToMany(mappedBy = "user")
  @JsonManagedReference  // This prevents infinite loop  
  @JsonView(UserSerializer.UserWithPosts.class)  
  private List<Post> posts;

  // .. getters and setters bellow
}