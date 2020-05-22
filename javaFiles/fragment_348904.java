@Column(columnDefinition = "enum('BULGARIA','UNITED KINGDOM')")
@Enumerated(EnumType.STRING)
private Language lang;

@Column(columnDefinition = "enum('ADMIN','USER')")
@Enumerated(EnumType.STRING)
private Role role;