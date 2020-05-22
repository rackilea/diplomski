@ElementCollection
@CollectionTable(name = "Recipes", 
    joinColumns = @JoinColumn(name = "product_id"))
@MapKeyJoinColumn(name = "material_id")
@Column(name = "count")
private Map<Material, Integer> recipe;