@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "id")
@CollectionTypeInfo(name = "package.MyCustomSet")
public Set<MyEmbeddable> getMyEmbeddables() {
    ...
}