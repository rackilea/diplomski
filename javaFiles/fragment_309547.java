@Id
@SequenceGenerator(name="webuser_idwebuser_seq",
                   sequenceName="webuser_idwebuser_seq",
                   allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator="webuser_idwebuser_seq")
@Column(name = "idwebuser", updatable=false)
private Integer id;