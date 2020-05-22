@JsonIgnore
private KeyValueCollection userData;

private String participants = "";

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
private boolean garbageEligible;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) 
private String interactionType ;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
private LinkedList<InteractionInfo> interactions;