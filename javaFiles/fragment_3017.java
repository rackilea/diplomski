@ManyToMany
@JoinTable(
name="tbl_settings_objecteproxy_v2",
joinColumns = @JoinColumn(name = "id"),
inverseJoinColumns = @JoinColumn( name = "objectproxy_id"))
private Set<SomeObject> objectproxy;