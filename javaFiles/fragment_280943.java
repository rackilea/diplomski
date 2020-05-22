@Temporal(TemporalType.TIMESTAMP)
@Generated(value = GenerationTime.INSERT)
@Column(name = "created_time", updatable = false, insertable = false, nullable = false,
        columnDefinition = "datetime default CURRENT_TIMESTAMP")
private Date createdTime;

@Temporal(TemporalType.TIMESTAMP)
@Generated(value = GenerationTime.ALWAYS)
@Column(name = "modified_time", updatable = false, insertable = false, nullable = false,
        columnDefinition = "datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
private Date modifiedTime;