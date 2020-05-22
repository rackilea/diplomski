public class PatientEntity implements Patient {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column
    private UUID id;