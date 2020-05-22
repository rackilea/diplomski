@JoinColumns({
        @JoinColumn(name = "linkedObjectID", referencedColumnName = "id"),
        @JoinColumn(name = "linkedObjectName", referencedColumnName = "linkedObjectName")
    })
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<FrameworkFiles> framework_files1 = new ArrayList<>();