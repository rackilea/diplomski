/** The id. */
@XmlTransient
@Id
// NOK, forces immediate flush
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// NOK, in my case defaults to IDENTITY
// @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
// NOK, MySQL doesn't support sequences...
// @SequenceGenerator(name = "sequence_generator", sequenceName = "GLOBAL_SEQUENCE", allocationSize = 100, initialValue = 1000) 
// OK, but ACID is lost
@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
@TableGenerator(name = "table_generator", table = "SEQUENCE_GENERATOR", pkColumnName = "NAME", valueColumnName = "NEXT_VAL", allocationSize = 100)
@Column(name = "ID")
protected Long id;