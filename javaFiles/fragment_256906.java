@MappedSuperclass
public abstract class DomainObject implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
 @Column(name = "id", updatable = false, nullable = false)
 private Long id;

 .. rest of class
}