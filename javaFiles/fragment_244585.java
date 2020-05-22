@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
@SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
public Long getId() {
     return id;
}