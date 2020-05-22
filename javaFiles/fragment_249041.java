@OneToOne(cascade = CascadeType.ALL, mappedBy = "conflictOfInterest")
@XmlTransient
@JsonIgnore
@Getter
@Setter
private RequestForCorrection requestForCorrection;      

@OneToOne
@JoinColumn(name = "conflict_of_interest_id", nullable = false)
@JsonIgnore
@Getter
@Setter
private ConflictOfInterest conflictOfInterest;