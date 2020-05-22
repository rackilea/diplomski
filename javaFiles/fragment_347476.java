@Id
@GenericGenerator(name = "uuid", strategy = "uuid2")
@GeneratedValue(generator = "uuid")
@Column(name = "key", unique = true, nullable = false)
@Type(type="pg-uuid")
private UUID key;