@JoinTable(
    name = "run_visitedstation",
    joinColumns = @JoinColumn(name = "run_id"),
    inverseJoinColumns = @JoinColumn(name = "visitedstation_id")
)
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@OrderBy("hours ASC, minutes ASC")
private List<VisitedStation> visitedstations;