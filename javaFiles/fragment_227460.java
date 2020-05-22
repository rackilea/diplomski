@OneToOne(orphanRemoval = true, optional = true, cascade = {CascadeType.ALL}, mappedBy = "person")
@Getter
@Setter
private CarDetails carDetails; 


@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
@JoinColumn(name = "person_id")//You will need to create foreign key
@Getter
@Setter
private Person person;