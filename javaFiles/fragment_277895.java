@Id
@GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "sequence-generator"
)
@SequenceGenerator(
    name = "sequence-generator",
    sequenceName = "the_sequence_name"
)
private long id;