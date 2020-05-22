@ManyToOne(targetEntity = ForeignObject.class, fetch = FetchType.EAGER)
@JoinColumn(name = "FOREIGN_OBJECT_ID", referencedColumnName = "FOREIGN_OBJECT_ID", 
                       nullable = false, insertable = false, updatable = false)
private ForeignObject foreignObject;

@Column(name = "FOREIGN_OBJECT_ID")
private Integer foreignObjectId;