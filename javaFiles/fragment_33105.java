@OneToMany(mappedBy="car")
private List<Type> types;

add to Type class:

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="Typeid")
Cars car;