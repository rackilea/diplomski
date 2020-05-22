/**
 * Unidirectional relationship between Employee and Team.
 */
@ManyToOne
@JoinColumn(name = "team_id")
private Team team;