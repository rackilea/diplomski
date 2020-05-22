@Column(name = "heure_debut")
@Temporal(TemporalType.TIMESTAMP)
private Date heureDebut;

@Column(name = "heure_fin")
@Temporal(TemporalType.TIMESTAMP)
private Date heureFin;