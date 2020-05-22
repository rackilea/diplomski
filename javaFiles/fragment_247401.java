@Id 
@SequenceGenerator(name="pk_sequence",sequenceName="entity_id_seq", allocationSize=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
@Column(name="id", unique=true, nullable=false)
public int getId() {
    return this.id;
}