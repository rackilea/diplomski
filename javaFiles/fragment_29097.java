@Id
@GeneratedValue(
   strategy = GenerationType.SEQUENCE,
   generator = "entity_id_seq"
)
@SequenceGenerator(
   name = "entity_id_seq",
   sequenceName = "global_id_sequence",
   allocationSize = 1
) 
@Column(
   name = "id",
   unique = true,
   updatable = false,
   nullable = false
)
protected Long id;