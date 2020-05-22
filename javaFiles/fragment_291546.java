@Id
@Column(name="policy_id")
private policyId;

@MapsId
@OneToOne
@JoinColumn(name = "policy_id")
private Policy policy;