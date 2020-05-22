public class GlobalPart extends ModelBase implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "globalPart")
    private Set<PartRelease> partReleases;

    @Column(name = "RELEASES")
    private Long releasesNumber;
}

public class PartRelease extends ModelBase implements Serializable {
    @ManyToOne
    @JoinColumn(name = "COLLECTION_ID", referencedColumnName = "RELEASES")
    private GlobalPart globalPart;

}