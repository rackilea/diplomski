@JsonIgnoreProperties("site")
@OneToMany(mappedBy="site")
private List<Building> buildings;

@JsonIgnoreProperties("buildings")
@ManyToOne
private Site site;