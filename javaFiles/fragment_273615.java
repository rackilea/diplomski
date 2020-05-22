class House {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_town")
    private Town town;

    @OneToMany(mappedBy = "house")
    private List<Owner> owners;

}

class Owner {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_house")
    private House house;

    @OneToOne
    @JoinColumn(name = "fk_owner_info")
    private OwnerInfo ownerInfo;

}

class OwnerInfo {

    @OneToOne(mappedBy = "ownerInfo", fetch = FetchType.LAZY)
    private Owner owner;

}