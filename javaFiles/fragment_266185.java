@Id
@ManyToOne
@JoinColumn(referencedColumnName = "username")
Member requester;

@Id
@ManyToOne
@JoinColumn(referencedColumnName = "username")
Member friend;