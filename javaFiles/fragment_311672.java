@Id
@GenericGenerator(
    name = "assigned-sequence",
    strategy = "com.vladmihalcea.book.hpjp.hibernate.identifier.AssignedSequenceStyleGenerator",
    parameters = @org.hibernate.annotations.Parameter(
        name = "sequence_name", 
        value = "post_sequence"
    )
)
@GeneratedValue(
    generator = "assigned-sequence", 
    strategy = GenerationType.SEQUENCE
)
private Long id;