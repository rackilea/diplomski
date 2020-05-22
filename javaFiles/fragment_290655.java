@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
@GenericGenerator(name = "IdGenerator",
    strategy = "com.project.generator.IdGenerator",
    parameters = {
        @Parameter(name = "sequence", value = "xyz_id_sequence")
    })
private Integer id;