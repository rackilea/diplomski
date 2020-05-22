@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
protected Long id;
...
}