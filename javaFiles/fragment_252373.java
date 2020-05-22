@MappedSuperclass
@Access(FIELD)
abstract class IdentifiedEntity {
    @Id
    @SequenceGenerator(name = "seqgen", sequenceName = "sequencer")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqgen")
    private int id;
    ...
}