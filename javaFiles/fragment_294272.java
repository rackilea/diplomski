@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "ID")
private Integer ID;

@ManyToOne
@JoinColumn(name = "voterID")
private Person voter;

@ManyToOne
@JoinColumn(name = "votedForID")
private Person votedFor;

@Column(name = "vote")
private Boolean vote;

public void cast(Person voter, Person votedFor, boolean vote) {
    // Maybe assert that this vote has not already been casted
    this.voter = voter;
    this.votedFor = votedFor;
    this.vote = vote;
}

public Integer getID() {
    return ID;
}

public Boolean isUpVote() {
    return vote;
}

public Boolean isDownVote() {
    return !vote;
}

public Person getVoter() {
    return voter;
}

public Person getVotedFor() {
    return votedFor;
}