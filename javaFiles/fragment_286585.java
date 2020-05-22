@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
public int getUserId() {
    return userId;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "registration_token_id")
public int getRegistrationTokenId() {
    return registrationTokenId;
}