@Column(name="parent_id", insertable=false, updatable=false)
private String parentId;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="parent_id")
private Parent parent;