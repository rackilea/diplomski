@ManyToMany
    @CollectionTable(joinColumns = { @JoinColumn(name = "entityA"),
            @JoinColumn(name = "entityB") }, uniqueConstraints = { @UniqueConstraint(columnNames = {
            "entityA", "entityB", "history" }) })
    @OrderColumn(name = "POSITION")
    private List<EntityC> history;