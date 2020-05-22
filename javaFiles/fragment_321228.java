@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "STATE_ID", insertable = false, updatable=false)
private State state;

@Column(name = "STATE_ID")
private Long stateId;