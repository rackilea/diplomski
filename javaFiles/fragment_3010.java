@CreatedTimestamp
@Column(name = "date_request", columnDefinition = "datetime")
private Timestamp whenRequest;

@UpdatedTimestamp
@Column(name = "date_friends", columnDefinition = "datetime")
private Timestamp whenFriends;