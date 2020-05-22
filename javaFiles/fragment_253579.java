@OneToMany(orphanRemoval = true)
@LazyCollection(LazyCollectionOption.FALSE)
@JoinColumn(name = "entry_id")
@OrderBy("precedence")
private List<EntryAddress> addresses;

@OneToMany(orphanRemoval = true)
@LazyCollection(LazyCollectionOption.FALSE)
@JoinColumn(name = "entry_id")
@OrderBy("precedence")
private List<EntryContact> contacts;