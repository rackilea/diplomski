@ElementCollection
@CollectionTable( name = "user_team", 
        joinColumns = @JoinColumn( name = "user_id" ) )
@Column( name = "team_name" )
@Enumerated(EnumType.STRING)
@Convert( converter = TeamToStringConverter.class )
private Set<Team> teams;