@Entity(value = "delta", noClassnameStored = true)
public final class DeltaEntity extends BaseEntity {
    private static final long serialVersionUID = -2770175650780701908L;

    private String entityClass; // Do not call this className as Morphia will
                            // try to work some magic on this automatically
    private ObjectId entityId;
    private String entityUuid;
    private String userEmail;
    private String delta;

    public DeltaEntity() {
        super();
    }

    public DeltaEntity(final String entityClass, final ObjectId entityId, final String entityUuid,
            final String userEmail, final String delta) {
        this();
        this.entityClass = entityClass;
        this.entityId = entityId;
        this.entityUuid = entityUuid;
        this.userEmail = userEmail;
        this.delta = delta;
    }