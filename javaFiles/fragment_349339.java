public enum Gender {
    MALE, FEMALE;
}

@Enumerated(EnumType.STRING)
@Column(columnDefinition = "ENUM('User', 'Moderator', 'Admin')")
public Role role;
}