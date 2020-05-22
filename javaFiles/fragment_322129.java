@Entity
class User extends UserDetails {
    @Id
    private Long id;
}


@MappedSuperclass
class User extends UserDetails {
    @NotNull
    @NotBlank
    private String username;
    private String password;
}


@MappedSuperclass
class UserProfile {
    private String name;
    private String address;
    @Email
    private String email;
}