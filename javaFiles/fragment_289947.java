@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "G1")
@SequenceGenerator(name = "G1", sequenceName = "LOG_SEQ")
@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
public int getId() {
    return this.id;
}