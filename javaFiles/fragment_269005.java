@Id
@Column(name="interest")
private String interest;

@Id
@Column(name="festival_number", unique=true, nullable=false)
@GeneratedValue(generator="gen")
@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="festival_info"))
private String festivalNumber;