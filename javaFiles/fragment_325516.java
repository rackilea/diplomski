@Column(name="`ID`", nullable=false, unique=true)    
@Id 
private int filehId;

@JoinColumn(name = "id", referencedColumnName = "id")
@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
@MapsId
private Fileh fileh;