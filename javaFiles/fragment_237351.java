@Access(AccessType.FIELD) // Default is field access
class Child {
    private Integer id;

    @Column(name = "name")
    private String name;

    @Access(AccessType.PROPERTY) // Use property access for id
    @Id @Column(name = "id", unique = true, nullable = false)
    public Integer getId() { ... }

    ...   
}