@ManyToMany(fetch = FetchType.LAZY, mappedBy="cars")
@JsonBackReference
private Set<part> parts;


@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
          name = "car_part",
          joinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
@JsonManagedReference
private Set<car> cars;