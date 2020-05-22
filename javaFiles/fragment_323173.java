@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractBaseEntity { 

    public static final long INVALID_OBJECT_ID = -42;

    @Version
    private int version;    

    @Id
    @SequenceGenerator(name = "sequence-object", sequenceName = "ID_MASTER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-object")
    @Column(name = "id")
    protected Long objectID = INVALID_OBJECT_ID;

    public final int getVersion() {
        return version;
    }

    @Override
    public long getObjectID() {
        return objectID;
    }

    // ... maybe other methods or fields ...
}