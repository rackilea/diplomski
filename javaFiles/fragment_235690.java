ClassTwo{

    @Id
    @EmbeddedId
    private TableTwoId id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "classTwo")  
    private Set<ClassThree> classTwoList = new HashSet<ClassThree>(0); 

    @ManyToOne
    @JoinColumns({
       @JoinColumn(name="COL_A",insertable=false, updatable=false, referencedColumnName="COL_A"),
       @JoinColumn(name="COL_B",insertable=false, updatable=false,referencedColumnName="COL_B") 
    })
    private ClassOne classOne;
}


ClassThree{

    @Id
    @EmbeddedId
    private TableThreeId id;

    @ManyToOne
    @JoinColumns({
       @JoinColumn(name="COL_A",insertable=false, updatable=false, referencedColumnName="COL_A"),
       @JoinColumn(name="COL_B",insertable=false, updatable=false, referencedColumnName="COL_B") ,
       @JoinColumn(name="COL_C",insertable=false, updatable=false, referencedColumnName="COL_C")
    })
    private ClassTwo classTwo;
}