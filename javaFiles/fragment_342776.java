@ElementCollection
@CollectionTable(name = "my_options", 
        joinColumns = @JoinColumn( name = "mything_id"))
@Column(name = "option")
@Enumerated(EnumType.STRING)
private Set<MyOptions> options;