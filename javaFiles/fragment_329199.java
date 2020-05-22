@Id
@SequenceGenerator(name = "local_genName", 
    sequenceName = "db_GenName")
@GeneratedValue(strategy = GenerationType.AUTO, 
generator="local_genName")
@Column(name="id")
private Long id;