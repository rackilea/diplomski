class ParentEntity {
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    Collection<SingleSleeper> singleSleepers;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    Collection<RutEntry> rutEntries;
}