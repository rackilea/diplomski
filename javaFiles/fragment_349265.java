@CollectionOfElements(targetElement = Double.class)
@JoinTable(name = "COLLECTION_TABLE", 
    joinColumns = @JoinColumn(name = "PARENT_ID"))
@org.hibernate.annotations.MapKey(targetElement = String.class, 
    columns = @Column(name = "SOME_KEY"))
@Column(name = "SOME_VALUE")
private Map data;