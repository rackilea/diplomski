@ElementCollection
@CollectionTable(name = "MENGEN",
        joinColumns = @JoinColumn(name = "AUFTRAGSPOS_ID"))
@MapKeyJoinColumn(name = "MATERIAL") 
@Column(name = "AMOUNT")
private Map<Material, Integer> amounts = new HashMap<Material, Integer>();