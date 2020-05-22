@Id
private Integer id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "animal_id", nullable = false, insertable = false, updatable = false)
private AnimalEntity animalEntity;

@Column(name = "animal_id")
private Integer animalId;