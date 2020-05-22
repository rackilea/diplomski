@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class AbstractPersistable<T> implements Serializable {
  private static final long serialVersionUID = -537959523291969928L;

  @Id
  @JsonProperty("_id")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "id", nullable = false, updatable = false, unique = true)
  private T id;

  @CreatedDate
  @Column(name = "created_on", nullable = false, updatable = false)
  private Instant createdOn;

  @CreatedBy
  @Column(name = "created_by", nullable = false)
  private String createdBy;

  @LastModifiedDate
  @Column(name = "modified_on", nullable = false)
  private Instant modifiedOn;

  @LastModifiedBy
  @Column(name = "modified_by", nullable = false)
  private String modifiedBy;

  @Version
  @JsonProperty("_version")
  private Integer version;

  AbstractPersistable() { } // No-args constructor required by JPA spec

  public T getId() { return id; }

  public Instant getCreatedOn() { return createdOn; }

  public String getCreatedBy() { return createdBy; }

  public Instant getModifiedOn() { return modifiedOn; }

  public String getModifiedBy() { return modifiedBy; }

  public Integer getVersion() { return version; }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("createdOn", createdOn)
        .append("createdBy", createdBy)
        .append("modifiedOn", modifiedOn)
        .append("modifiedBy", modifiedBy)
        .append("version", version)
        .toString();
  }
}