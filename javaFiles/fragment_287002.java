@Entity
Class A {

    @Id
    @Column(name="A_ID")
    private Long id;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy="a"
    )
    Collection<C> values;

    ...
}


@Entity
Class B {

    @Id
    @Column(name="B_ID")
    private Long id;

    ...
}


@Entity
Class C {

    @EmbeddedId
    private CId cId;

    @ManyToOne
    @JoinColumn(name="A_ID")
    @MapsId("aId") // maps aId attribute of embedded id
    private A a;

    @ManyToOne
    @JoinColumn(name="B_ID")
    @MapsId("bId") // maps bId attribute of embedded id
    private B b;

    ...
}

@Embeddable
Class CId {

    private Long aId; // corresponds to PK type of A

    private Long bId; // corresponds to PK type of B

    ...
}