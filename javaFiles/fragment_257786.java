@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
@ManyToOne(optional = false)
@Basic(optional = false)
@NotNull
@Column(name = "USER_ID")
private Integer userId;