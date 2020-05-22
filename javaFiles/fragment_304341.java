@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,
        CascadeType.PERSIST,CascadeType.REFRESH})
@JoinTable(
        name = "pielegniarki_sale",
        joinColumns = @JoinColumn(name = "nr_sali"),
        inverseJoinColumns = @JoinColumn(name = "id_pielegniarki")
)
private List<Pielegniarka> pielegniarki;