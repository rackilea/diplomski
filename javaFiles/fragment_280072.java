@JoinColumn(name = "player_id", referencedColumnName = "player_id")
@ManyToOne(optional = false)
private Player player;

@Column(name="player_id", insertable=false, updatable=false)
private Long playerId;