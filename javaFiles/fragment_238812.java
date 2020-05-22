@MappedSuperclass
public abstract class BaseEntity {
       @Id
       @GeneratedValue
       @Column(name = "id")
       @SearchableId
       protected Long id;
       @Column(name = "uuid", unique = true, nullable = false)
       protected String uuid;
       @Column(name = "createdById")
       protected Long createdById;
       @Temporal(value = TemporalType.TIMESTAMP)
       @Column(name = "createdOn", nullable = false)
       protected Date createdOn;
       @Column(name = "changedById")
       protected Long changedById;
       @Temporal(value = TemporalType.TIMESTAMP)
       @Column(name = "changedOn", nullable = false)
       protected Date changedOn;
       @Column(name = "changedOnValue", nullable = false)
       protected Long changedOnValue;
       @Column(name = "active")
       protected Boolean active;
       @Column(name = "deactivatedById")
       protected Long deactivatedById;
       @Temporal(value = TemporalType.TIMESTAMP)
       @Column(name = "deactivatedOn")
       protected Date deactivatedOn;
       @Version
       @Column(name = "version")
       protected Integer version = 0;
       @Column(name = "domainId")
       protected Long domainId;