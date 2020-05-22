@LazyCollection(LazyCollectionOption.FALSE)
@OrderColumn(name = "position")
@JoinTable(name = "yourTable", joinColumns = @JoinColumn(name = "query_id"))
@Type(type = "xml")
@Column(name = "xml_def")
@ElementCollection(targetClass = Serie.class)
@Override
public List<Serie> getSeries() {
    return series;
}