@Id
@Column(name="USER_ID")
private String userId;  // I want USER_ID act as both primary key and foreign key

@OneToOne
@PrimaryKeyJoinColumn(name="USER_ID")
UserProfile user;